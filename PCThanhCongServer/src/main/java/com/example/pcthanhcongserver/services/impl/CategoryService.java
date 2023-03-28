package com.example.pcthanhcongserver.services.impl;

import com.example.pcthanhcongserver.base.BasePagination;
import com.example.pcthanhcongserver.contants.StatusCodeEnum;
import com.example.pcthanhcongserver.dto.create.CreateCategoryDTO;
import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.dto.update.UpdateCategoryDTO;
import com.example.pcthanhcongserver.entity.Category;
import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.repositories.ICategoryReppository;
import com.example.pcthanhcongserver.services.ICategoryService;
import com.example.pcthanhcongserver.services.IProductService;
import com.example.pcthanhcongserver.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class CategoryService extends BasePagination<Category, ICategoryReppository> implements ICategoryService {
    @Autowired
    private ICategoryReppository reppository;
    @Autowired
    private IProductService productService;

    @Autowired(required = false)
    private ModelMapper modelMapper;
    @Autowired
    public CategoryService(ICategoryReppository reppository){
        super(reppository);
    }
    @Override
    public PaginateDTO<Category> getList(Integer page, Integer perPage, GenericSpecification<Category> specification) {
        return null;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return reppository.findCategoryById(id);
    }

    @Override
    public Category create(CreateCategoryDTO CategoryDTO) throws Exception {
        Category oldCategory = reppository.findByName(CategoryDTO.getName());
        if(oldCategory != null){
            throw new Exception("Category has already exists !");
        }
        Category newCategory = modelMapper.map(CategoryDTO,Category.class);
        return reppository.save(newCategory);
    }

    @Override
    public Category update(UpdateCategoryDTO categoryDTO, Category currentCategory) throws Exception {
        Category updated = modelMapper.map(categoryDTO, Category.class);
        if (reppository.findByName(categoryDTO.getName()) != null)
            throw new Exception("Category has already exists !");
        modelMapper.map(updated,currentCategory);
        return  reppository.save(currentCategory);
    }

    @Override
    public void deleteById(Integer categoryId) throws Exception {
        Category category = reppository.findCategoryById(categoryId);
        if (category == null)
            throw new Exception("Not found category");
        if(!category.getProducts().isEmpty())
            throw new Exception("Cannot delete category");
        reppository.delete(category);
    }

    @Override
    public void lockCategory(Integer id) {
        Category category = reppository.findCategoryById(id);
        category.setStatus(StatusCodeEnum.NOT_ACTIVE);
        for (Product product: category.getProducts()){
            productService.lockProductStatus(product.getId());
        }
        reppository.save(category);

    }

    @Override
    public void unLockCategory(Integer id) {
        Category category = reppository.findCategoryById(id);
        category.setStatus(StatusCodeEnum.ACTIVE);
        for (Product product: category.getProducts()){
            productService.unLockProductStatus(product.getId());
        }
        reppository.save(category);
    }

    @Override
    public boolean existedByName(String name) {
        return reppository.existsByName(name);
    }
}

package com.example.pcthanhcongserver.services;

import com.example.pcthanhcongserver.dto.create.CreateCategoryDTO;
import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.dto.update.UpdateCategoryDTO;
import com.example.pcthanhcongserver.entity.Category;
import com.example.pcthanhcongserver.specifications.GenericSpecification;

public interface ICategoryService {
    PaginateDTO<Category> getList(Integer page, Integer perPage, GenericSpecification<Category> specification);
    Category getCategoryById(Integer id);
    Category create(CreateCategoryDTO createCategoryDTO) throws Exception;
    Category update(UpdateCategoryDTO categoryDTO, Category currentCategory) throws Exception;
    void deleteById(Integer categoryId) throws Exception;
    void lockCategory(Integer id);
    void unLockCategory(Integer id);
    boolean existedByName(String name);
}

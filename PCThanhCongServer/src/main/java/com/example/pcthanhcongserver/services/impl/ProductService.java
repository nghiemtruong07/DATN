package com.example.pcthanhcongserver.services.impl;

import com.example.pcthanhcongserver.base.BasePagination;
import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.forms.CreateProductForm;
import com.example.pcthanhcongserver.forms.UpdateProductForm;
import com.example.pcthanhcongserver.repositories.IProductRepository;
import com.example.pcthanhcongserver.services.ICategoryService;
import com.example.pcthanhcongserver.services.IProductService;
import com.example.pcthanhcongserver.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BasePagination<Product, IProductRepository> implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    public ProductService(IProductRepository iProductRepository){
        super(iProductRepository);
    }
    @Override
    public PaginateDTO<Product> getAllProducts(Integer page, Integer perPage, GenericSpecification<Product> specification) {
        return this.paginate(page,perPage,specification);
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findProductById(id);
    }

    @Override
    public Product getProductByTitle(String title) {
        return repository.findProductByTitle(title);
    }

    @Override
    public Product getProductBySpecification(String specification) {
        return repository.findProductBySpecifications(specification);
    }

    @Override
    public Product creaProduct(CreateProductForm form) {
        Product product = form.toEntity();
        product.setCategory(categoryService.getCategoryById(form.getCategoryId()));
        return repository.save(product) ;
    }

    @Override
    public void updateProduct(Integer id, UpdateProductForm form) {
        Product product = form.toEntity();
        product.setId(id);
        product.setCategory(categoryService.getCategoryById(repository.findProductById(id).getCategory().getId()));
        product.setCreateDate(repository.findProductById(id).getCreateDate());
        repository.save(product);
    }

    @Override
    public void UpdateProductAmount(Product product, Integer amount) {
        product.setAmount(amount);
        repository.save(product);

    }

    @Override
    public void unLockProductStatus(Integer id) {

    }

    @Override
    public void lockProductStatus(Integer id) {

    }

    @Override
    public boolean existsProductByTitle(String title) {
        return false;
    }

    @Override
    public long getProductCount() {
        return 0;
    }
}

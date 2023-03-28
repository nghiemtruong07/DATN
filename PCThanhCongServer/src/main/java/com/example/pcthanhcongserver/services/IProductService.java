package com.example.pcthanhcongserver.services;

import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.forms.CreateProductForm;
import com.example.pcthanhcongserver.forms.UpdateProductForm;
import com.example.pcthanhcongserver.specifications.GenericSpecification;

public interface IProductService {
    public PaginateDTO<Product> getAllProducts(Integer page, Integer perPage, GenericSpecification<Product> specification);

    public Product getProductById(Integer id);

    public Product getProductByTitle(String title);

    public Product getProductBySpecification(String specification);

    Product creaProduct(CreateProductForm form);

    void updateProduct(Integer id, UpdateProductForm form);

    void UpdateProductAmount(Product product, Integer amount);

    void unLockProductStatus(Integer id);

    void lockProductStatus(Integer id);
    boolean existsProductByTitle(String title);
    long getProductCount();

}

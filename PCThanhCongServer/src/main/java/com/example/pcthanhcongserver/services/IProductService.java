package com.example.pcthanhcongserver.services;

import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.forms.CreateProductForm;
import com.example.pcthanhcongserver.specifications.GenericSpecification;

public interface IProductService {
    public PaginateDTO<Product> getAllProducts(Integer page, Integer perPage, GenericSpecification<Product> specification);

    public Product getProductById(Integer id);

    public Product getProductByTitle(String titile);

    public Product getProductBySpecification(String specification);

    Product creaProduct(CreateProductForm form);

}

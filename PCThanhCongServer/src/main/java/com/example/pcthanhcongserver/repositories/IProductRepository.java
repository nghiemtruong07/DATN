package com.example.pcthanhcongserver.repositories;

import com.example.pcthanhcongserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    Product findProductById(Integer id);

    Product findProductByTitle(String title);
    Product findProductBySpecifications(String specifications);
    boolean existsProductByTitle(String title);

}

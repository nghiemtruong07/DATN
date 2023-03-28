package com.example.pcthanhcongserver.repositories;

import com.example.pcthanhcongserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICategoryReppository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    Category findByName(String name);
    Category findCategoryById(Integer id);
    boolean existsByName(String name);
}

package com.mateuszjanczak.thymeleaf.service;

import com.mateuszjanczak.thymeleaf.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getList();
    void addProduct(Product product);
}

package com.mateuszjanczak.thymeleaf.service;

import com.mateuszjanczak.thymeleaf.dto.ProductRequest;
import com.mateuszjanczak.thymeleaf.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(int id);
    List<Product> getList();
    Product addProduct(ProductRequest product);
    Optional<Product> editProduct(int id, ProductRequest productRequest);
    void removeProduct(int id);
}

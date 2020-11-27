package com.mateuszjanczak.thymeleaf.web;

import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String homepage() {
        return "index.html";
    }

    @GetMapping("/products")
    public String products() {
        return "products.html";
    }

    @GetMapping("/products/new")
    public String productForm() {
        return "productForm.html";
    }

}

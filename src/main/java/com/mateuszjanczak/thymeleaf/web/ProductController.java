package com.mateuszjanczak.thymeleaf.web;

import com.mateuszjanczak.thymeleaf.model.Product;
import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String homepage() {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> productList = productService.getList();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/products/new")
    public String productForm() {
        return "productForm";
    }

    @PostMapping("/products/new")
    public String productFormSubmit() {
        return "products";
    }

}

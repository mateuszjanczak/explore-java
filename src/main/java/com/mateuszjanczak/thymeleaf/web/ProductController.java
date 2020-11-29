package com.mateuszjanczak.thymeleaf.web;

import com.mateuszjanczak.thymeleaf.model.Product;
import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("productList", productService.getList());
        return "products";
    }

    @GetMapping("/products/new")
    public String productForm(Model model) {
        model.addAttribute("newProduct", new Product());
        return "productForm";
    }

    @PostMapping("/products/new")
    public String productFormSubmit(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}

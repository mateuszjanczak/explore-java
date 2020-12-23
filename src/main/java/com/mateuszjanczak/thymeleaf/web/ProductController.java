package com.mateuszjanczak.thymeleaf.web;

import com.mateuszjanczak.thymeleaf.dto.ProductRequest;
import com.mateuszjanczak.thymeleaf.model.Product;
import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/products/new")
    public String productFormSubmit(@Valid @ModelAttribute ProductRequest productRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "productForm";
        }
        productService.addProduct(productRequest);
        return "redirect:/products";
    }
}

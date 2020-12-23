package com.mateuszjanczak.thymeleaf.web;

import com.mateuszjanczak.thymeleaf.dto.ProductRequest;
import com.mateuszjanczak.thymeleaf.model.Product;
import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

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
        model.addAttribute("productRequest", new ProductRequest());
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

    @GetMapping("/products/edit/{id}")
    public String productFormEdit(@PathVariable("id") int id, Model model) {
        Optional<Product> optionalProduct = productService.getById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("productRequest", ProductRequest.valueOf(product));
            return "productForm";
        } else {
            return "404";
        }
    }

    @PostMapping("/products/edit/{id}")
    public String productFormEditSubmit(@PathVariable("id") int id, @Valid @ModelAttribute ProductRequest productRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "productForm";
        }
        productService.editProduct(id, productRequest);
        return "redirect:/products";
    }

    @GetMapping("/products/remove/{id}")
    public String productRemove(@PathVariable("id") int id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }
}

package com.mateuszjanczak.thymeleaf.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Component
public class Product {
    @NotEmpty(message = "Id must be not empty")
    private int id;

    @NotEmpty(message = "Name must be not empty")
    private String name;

    @NotEmpty(message = "Description must be not empty")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @Digits(integer = 5, fraction = 2, message = "Price must contain numbers")
    @DecimalMin(value = "0.01", message = "Price should not be less than 0")
    private float price;
}

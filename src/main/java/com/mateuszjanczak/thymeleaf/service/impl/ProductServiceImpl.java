package com.mateuszjanczak.thymeleaf.service.impl;

import com.mateuszjanczak.thymeleaf.model.Product;
import com.mateuszjanczak.thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ArrayList<Product> productList;

    public ProductServiceImpl() {
        this.productList = new ArrayList<>();
        productList.add(new Product("Pear", "a pome fruit of a tree (genus Pyrus, especially P. communis) of the rose family that typically has a pale green or brownish skin, a firm juicy flesh, and an oblong shape in which a broad base end tapers upward to a narrow stem end", 5.00f));
        productList.add(new Product("Apple", "the fleshy, usually rounded red, yellow, or green edible pome fruit of a usually cultivated tree (genus Malus) of the rose family", 2.50f));
        productList.add(new Product("Grape", "a smooth-skinned juicy light green or deep red to purplish black berry eaten dried or fresh as a fruit or fermented to produce wine", 3.50f));
        productList.add(new Product("Watermelon", "a large oblong or roundish fruit with a hard green or white rind often striped or variegated, a sweet watery pink, yellowish, or red pulp, and usually many seeds", 4.00f));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }
}

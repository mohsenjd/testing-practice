package com.mohsen.springboottesting.rest;

import com.mohsen.springboottesting.domain.Product;
import com.mohsen.springboottesting.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}

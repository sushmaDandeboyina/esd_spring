package com.prashantjain.yummyrest.controller;

import com.prashantjain.yummyrest.dto.CustomerRequest;
import com.prashantjain.yummyrest.dto.LoginRequest;
import com.prashantjain.yummyrest.dto.ProductRequest;
import com.prashantjain.yummyrest.entity.Product;
import com.prashantjain.yummyrest.service.CustomerService;
import com.prashantjain.yummyrest.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getByIDProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getByIDProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateByIDProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.updateByIDProduct(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByIDProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteByIDProduct(id));
    }

    @GetMapping("/top")
    public ResponseEntity<List<Product>> getTopProduct() {
        return ResponseEntity.ok(productService.top2());
    }

}

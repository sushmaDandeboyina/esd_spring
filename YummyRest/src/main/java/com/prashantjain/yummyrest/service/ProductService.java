package com.prashantjain.yummyrest.service;

import com.prashantjain.yummyrest.dto.ProductRequest;
import com.prashantjain.yummyrest.entity.Product;
import com.prashantjain.yummyrest.mapper.ProductMapper;
import com.prashantjain.yummyrest.repo.ProductRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo repo;
    private final ProductMapper mapper;
    public String createProduct(ProductRequest request) {
        Product product = mapper.toEntity(request);
        repo.save(product);
        return "Created";
    }


    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getByIDProduct(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String updateByIDProduct(Long id, ProductRequest request) {
        Product product = mapper.toEntity(request);
        Product oldProduct = repo.findById(id).orElse(null);
        if (oldProduct != null) {
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            repo.save(oldProduct);
            return "updated";

        }
        else {
            return "Product not found";
        }


    }

    public String deleteByIDProduct(Long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "deleted";
        }
        else {
            return "Product not found";
        }
    }

    public List<Product> top2() {
        return repo.top2();
    }
}

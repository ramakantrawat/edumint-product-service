package com.example.demo.service.impl;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.repository.ProductRepo;
import com.example.demo.service.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements Product {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductResponse getProduct(Long id) throws ProductNotFoundException {
        ProductEntity productEntity = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("This Product Not Available"));
        return ProductResponse.builder().id(productEntity.getId()).name(productEntity.getName()).description(productEntity.getDescription()).price(productEntity.getPrice()).build();
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<ProductEntity> products = productRepo.findAll();
        return products.stream().map(productEntity -> ProductResponse.builder().id(productEntity.getId()).price(productEntity.getPrice()).name(productEntity.getName()).description(productEntity.getDescription()).build()).collect(Collectors.toList());

    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        ProductEntity productEntity = productRepo.save(ProductEntity.builder().name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).build());

        return ProductResponse.builder().id(productEntity.getId()).description(productEntity.getDescription()).name(productEntity.getName()).price(productEntity.getPrice()).build();
    }
}

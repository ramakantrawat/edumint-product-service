package com.example.demo.service;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.response.ProductResponse;

import java.util.List;

public interface Product {
    ProductResponse getProduct(Long id) throws ProductNotFoundException;
    List<ProductResponse> getProducts();
    ProductResponse saveProduct(ProductRequest productRequest);
}

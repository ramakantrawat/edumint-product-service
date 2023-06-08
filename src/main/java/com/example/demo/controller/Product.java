package com.example.demo.controller;


import com.example.demo.constant.RestMappingConstant;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.response.BaseApiResponse;
import com.example.demo.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestMappingConstant.ProductConstant.PRODUCT_URL)
public class Product {
    @Autowired
    private com.example.demo.service.Product productService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseApiResponse<ProductResponse>> getProduct(@PathVariable Long id) throws ProductNotFoundException {
        return ResponseEntity.ok(new BaseApiResponse<>(productService.getProduct(id)));
    }

    @GetMapping
    public ResponseEntity<BaseApiResponse<List<ProductResponse>>> getProducts(){
        return ResponseEntity.ok(new BaseApiResponse<>(productService.getProducts()));
    }

    @PostMapping
    public ResponseEntity<BaseApiResponse<ProductResponse>> product(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.saveProduct(productRequest);
        return ResponseEntity.ok(new BaseApiResponse<>(productResponse));
    }
}

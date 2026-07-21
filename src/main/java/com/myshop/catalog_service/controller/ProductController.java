package com.myshop.catalog_service.controller;

import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDTO> getAll(
            @RequestParam(required = false) Long categoryId) {
        return service.findAll(categoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}

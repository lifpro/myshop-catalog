package com.myshop.catalog_service.controller;

import com.myshop.catalog_service.dto.CategoryDTO;
import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.service.CategoryService;
import com.myshop.catalog_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> create(
            @RequestBody CategoryDTO dto) {
        CategoryDTO created = service.create(dto);
        URI location = URI.create(
                "/api/v1/categories/" + created.id());
        return ResponseEntity.created(location)
                .body(created);
    }



}

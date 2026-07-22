package com.myshop.catalog_service.controller;

import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.service.ProductService;

import lombok.experimental.PackagePrivate;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



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

    @PostMapping
    public ResponseEntity<ProductDTO> create(
            @RequestBody ProductDTO dto) {
        ProductDTO created = service.create(dto);
        URI location = URI.create(
                "/api/v1/products/" + created.id());
        return ResponseEntity.created(location)
                .body(created);
    }

    @DeleteMapping("{id}")
    public  HttpEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        ProductDTO updated =  service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> patch(@PathVariable Long id, @RequestBody ProductDTO dto) {
        ProductDTO patched = service.patch(id, dto);
        return ResponseEntity.ok(patched);
    }
}

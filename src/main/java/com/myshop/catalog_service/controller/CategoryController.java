package com.myshop.catalog_service.controller;

import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ProductDTO> create(
            @RequestBody ProductDTO dto) {
        ProductDTO created = service.create(dto);
        URI location = URI.create(
                "/api/v1/products/" + created.id());
        return ResponseEntity.created(location)
                .body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(
            @PathVariable Long id,
            @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(
                service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

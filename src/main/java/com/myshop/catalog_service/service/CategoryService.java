package com.myshop.catalog_service.service;

import com.myshop.catalog_service.dto.CategoryDTO;
import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.model.Category;
import com.myshop.catalog_service.model.Product;
import com.myshop.catalog_service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    public CategoryService(CategoryRepository repository) {
        this.repository=repository;
    }

    public CategoryDTO create(CategoryDTO dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    private Category toEntity(CategoryDTO c) {
        return new Category(c.name());
    }
    private CategoryDTO toDto(Category c) {
        return new CategoryDTO(c.getId(),c.getName());
    }
}

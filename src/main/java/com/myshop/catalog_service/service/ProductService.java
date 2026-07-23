package com.myshop.catalog_service.service;

import com.myshop.catalog_service.dto.CategoryDTO;
import com.myshop.catalog_service.dto.ProductDTO;
import com.myshop.catalog_service.model.Category;
import com.myshop.catalog_service.model.Product;
import com.myshop.catalog_service.repository.CategoryRepository;
import com.myshop.catalog_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository repository
            ,CategoryRepository categoryRepository) {
        this.repository=repository;
        this.categoryRepository=categoryRepository;
    }
    public ProductDTO create(ProductDTO dto) {
        return toDto(this.repository.save(toEntity(dto)));
    }
    public void delete(Long id) {
    }
    public ProductDTO update(Long id,ProductDTO dto) {
        return dto;
    }
    public ProductDTO findById(Long id) {
       log.info("Recuperer le produit dont l'id="+id);
        return new ProductDTO(10L,"Farine",
                "Farine de blé",
                new BigDecimal(2000),10
                ,1L,"Céreale");
    }
    public List<ProductDTO> findAll(Long categoryId) {
        log.info("Recuperer la liste des produits de la catégorie "+categoryId);
        return null;
    }
    public Page<ProductDTO> search(Long categoryId,
                                   int page, int size, String sortBy) {
        var pageable = PageRequest.of(page, size,
                Sort.by(sortBy).ascending());
        return repository
                .findByCategoryId(categoryId, pageable)
                .map(this::toDto);
    }
    private Product toEntity(ProductDTO p) {
        Category cat=categoryRepository.findById(p.categoryId()).orElseThrow();
        Product p1=new Product();
        p1.setCategory(cat);
        p1.setName(p.name());
        p1.setDescription(p.description());
        p1.setPrice(p.price());
        p1.setStockQuantity(p.stockQuantity());
        return p1;
    }

    private ProductDTO toDto(Product p) {
        return new ProductDTO(p.getId(), p.getName(),
                p.getDescription(), p.getPrice(),
                p.getStockQuantity(),
                p.getCategory().getId(),
                p.getCategory().getName());
    }

}

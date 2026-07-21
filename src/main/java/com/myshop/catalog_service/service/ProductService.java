package com.myshop.catalog_service.service;

import com.myshop.catalog_service.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    public ProductService() {

    }
    public ProductDTO create(ProductDTO dto) {
        return  new ProductDTO(
                23L,
                dto.name(),
                dto.description(),
                dto.price(),
                dto.stockQuantity(),
                dto.categoryId(),
                dto.categoryName()
        );
    }
    public void delete() {
    }
    public void update() {
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
    public void search() {
    }
}

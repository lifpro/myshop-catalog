package com.myshop.catalog_service.repository;

import com.myshop.catalog_service.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(
            Long categoryId, Pageable pageable);

    List<Product> findByNameContainingIgnoreCase(
            String keyword);


    boolean existsByNameIgnoreCase(String name);

    @Query("SELECT p FROM Product p " +
            "WHERE p.price <= :max " +
            "ORDER BY p.price ASC")
    List<Product> findAffordable(
            @Param("max") BigDecimal max);
}

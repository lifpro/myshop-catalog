package com.myshop.catalog_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "myshop.catalog")
public record CatalogProperties (
    int pageSize,
    String defaultCurrency,
    boolean promotionsEnabled
){}
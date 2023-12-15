package api_products.products.entity.dto;

import api_products.products.entity.Products;

import java.math.BigDecimal;

public record ProductDTO(String sku, String product, Integer stock, String cost, String price) {
    public ProductDTO(Products products){
        this(products.getSku(), products.getProduct(), products.getStock(), products.getCost(), products.getPrice());
    }

}

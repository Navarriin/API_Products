package api_products.products.entity.dto;

import api_products.products.entity.Products;

public record ProductDTO(Long id, String sku, String product, Integer stock, Integer cost, Integer price) {
    public ProductDTO(Products products){
        this(products.getId(),products.getSku(), products.getProduct(), products.getStock(), products.getCost(), products.getPrice());
    }

}

package api_products.products.entity.dto;

public record ProductRequestDTO(String sku, String product, Integer stock, Integer cost, Integer price) {
}

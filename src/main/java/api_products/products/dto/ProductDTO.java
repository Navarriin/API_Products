package api_products.products.dto;

import api_products.products.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public record ProductDTO(
        Long id, String sku, String product,
        Integer stock, BigDecimal cost, BigDecimal price ) {
   public ProductDTO(Product products) {
       this(products.getId(), products.getSku(),products.getProduct(),
               products.getStock(), products.getCost(), products.getPrice());
   }
}

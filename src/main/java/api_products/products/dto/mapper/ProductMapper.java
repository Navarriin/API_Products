package api_products.products.dto.mapper;

import api_products.products.dto.ProductDTO;
import api_products.products.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        if(product == null) return null;

        return new ProductDTO(product);
    }

    public Product toEntity(ProductDTO body) {
        if(body == null) return null;

        Product product = new Product();
        if(body.id() != null) product.setId(body.id());

        product.setSku(body.sku());
        product.setProduct(body.product());
        product.setStock(body.stock());
        product.setCost(body.cost());
        product.setPrice(body.price());

        return product;
    }
}

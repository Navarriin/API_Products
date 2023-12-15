package api_products.products.repository;
import api_products.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepositoty extends JpaRepository<Products, UUID>{
}

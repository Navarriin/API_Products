package api_products.products.repository;
import api_products.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepositoty extends JpaRepository<Products, Long>{
}

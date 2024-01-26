package api_products.products.repository;
import api_products.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepositoty extends JpaRepository<Product, Long>{
}

package api_products.products.entity;
import api_products.products.entity.dto.ProductRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String product;
    private Integer stock;
    private Integer cost;
    private Integer price;

    public Products(ProductRequestDTO data){
        this.sku = data.sku();
        this.product = data.product();
        this.stock = data.stock();
        this.cost = data.cost();
        this.price = data.price();
    }
}

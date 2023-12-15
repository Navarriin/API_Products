package api_products.products.controller;

import api_products.products.entity.Products;
import api_products.products.entity.dto.ProductDTO;
import api_products.products.entity.dto.ProductRequestDTO;
import api_products.products.repository.ProductsRepositoty;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    private ProductsRepositoty repository;

    @GetMapping
    public List<ProductDTO> getAll(){
        List<ProductDTO> productList = repository.findAll().stream().map(ProductDTO::new).toList();
        return productList;
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        Optional<Products> optionalProducts = repository.findById(id);

        if(optionalProducts.isPresent()){
            Products product = optionalProducts.get();
            return ResponseEntity.ok(product);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody ProductRequestDTO data){
        Products productData = new Products(data);
        repository.save(productData);
        return ResponseEntity.ok(productData);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putProduct(@PathVariable Long id, @RequestBody ProductDTO data) {
        Optional<Products> optionalProducts = repository.findById((id));

        if(optionalProducts.isPresent()){
            Products products = optionalProducts.get();

            products.setSku(data.sku());
            products.setProduct(data.product());
            products.setStock(data.stock());
            products.setCost(data.cost());
            products.setPrice(data.price());
            return ResponseEntity.ok(products);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }

}

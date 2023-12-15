package api_products.products.controller;

import api_products.products.entity.Products;
import api_products.products.entity.dto.ProductDTO;
import api_products.products.repository.ProductsRepositoty;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

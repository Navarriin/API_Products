package api_products.products.controller;
import api_products.products.entity.dto.ProductDTO;
import api_products.products.repository.ProductsRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}

package api_products.products.controller;

import api_products.products.dto.ProductDTO;
import api_products.products.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ProductDTO>> listAll() {
        List<ProductDTO> productDTOList = productService.listAll();
        return ResponseEntity.ok().body(productDTOList);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getById(id);
        return ResponseEntity.ok().body(productDTO);
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProductDTO> createFood(@RequestBody ProductDTO body) {
        ProductDTO productDTO = productService.createProduct(body);
        return ResponseEntity.ok().body(productDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO body) {
        ProductDTO productDTO = productService.updateProduct(id, body);
        return ResponseEntity.ok().body(productDTO);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}

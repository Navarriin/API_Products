package api_products.products.service;

import api_products.products.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> listAll();
    public ProductDTO getById(Long id);
    public ProductDTO createProduct(ProductDTO body);
    public ProductDTO updateProduct(Long id, ProductDTO body);
    public void deleteProduct(Long id);
}

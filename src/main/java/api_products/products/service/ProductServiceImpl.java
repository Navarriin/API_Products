package api_products.products.service;

import api_products.products.dto.ProductDTO;
import api_products.products.repository.ProductsRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductsRepositoty productsRepositoty;

    @Override
    public List<ProductDTO> listAll() {
        return null;
    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO body) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO body) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}

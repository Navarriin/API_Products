package api_products.products.service;

import api_products.products.dto.ProductDTO;
import api_products.products.dto.mapper.ProductMapper;
import api_products.products.repository.ProductsRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductsRepositoty productsRepositoty;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> listAll() {
        return productsRepositoty.findAll()
                .stream().map(productMapper::toDTO)
                .sorted((product1, product2) -> product1.id().compareTo(product2.id()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return productsRepositoty.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public ProductDTO createProduct(ProductDTO body) {
        return productMapper.toDTO(productsRepositoty.save(productMapper.toEntity(body)));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO body) {
        return productsRepositoty.findById(id)
                .map(product -> {
                    product.setSku(body.sku());
                    product.setProduct(body.product());
                    product.setStock(body.stock());
                    product.setCost(body.cost());
                    product.setPrice(body.price());
                    return productMapper.toDTO(product);
                }).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepositoty.delete(productsRepositoty.findById(id)
                .orElseThrow(NoSuchElementException::new));
    }
}

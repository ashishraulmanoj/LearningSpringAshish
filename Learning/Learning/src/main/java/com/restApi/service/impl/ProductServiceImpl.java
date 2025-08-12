package com.restApi.service.impl;

import com.restApi.repository.ProductRepository;
import com.restApi.dto.ProductRequest;
import com.restApi.dto.ProductResponse;
import com.restApi.entity.Product;
import com.restApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        product = productRepository.save(product);
        return mapToResponse(product);
    }

    @Override
    public ProductResponse getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        product = productRepository.save(product);
        return mapToResponse(product);
    }

    @Override
    public void deleteProduct(long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);

    }

    @Override
    public ProductResponse[] getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toArray(ProductResponse[]::new);
    }

    ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

}

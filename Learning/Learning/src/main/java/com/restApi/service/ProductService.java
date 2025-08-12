package com.restApi.service;

import com.restApi.dto.ProductRequest;
import com.restApi.dto.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);
    ProductResponse getProductById(long id);
    ProductResponse updateProduct(long id, ProductRequest request);
    void deleteProduct(long id);
    ProductResponse[] getAllProducts();

}

package com.parth.productapp.product;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> getAllCompanies(int page);
    boolean updateProduct(Product product, Long id);
    void createProduct(Product product);
    boolean deleteProductById(Long id);
    Product getProductById(Long id);

}

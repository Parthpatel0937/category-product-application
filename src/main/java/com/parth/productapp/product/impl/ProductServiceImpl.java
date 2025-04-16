package com.parth.productapp.product.impl;

import com.parth.productapp.product.Product;
import com.parth.productapp.product.ProductRepository;
import com.parth.productapp.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllCompanies(int page){
        return productRepository.findAll(PageRequest.of(page,5));
    }

    @Override
    public boolean updateProduct(Product product, Long id){

        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product productToUpdate = productOptional.get();
            productToUpdate.setName(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setQuantity(product.getQuantity());
            productToUpdate.setDescription(product.getDescription());
            productRepository.save(productToUpdate);
            return true;
        }
        return false;

    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public boolean deleteProductById(Long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
}

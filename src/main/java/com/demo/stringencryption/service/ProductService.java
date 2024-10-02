package com.demo.stringencryption.service;

import com.demo.stringencryption.model.Product;
import com.demo.stringencryption.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product productReq) {
        Product product = new Product();
        product.setProductName(productReq.getProductName());
        product.setProductCode(productReq.getProductCode());
        product.setProductPrice(productReq.getProductPrice());
        product.setIsActive(productReq.getIsActive());
        product.setDeletedFlag(productReq.getDeletedFlag());
        return productRepository.save(product);
    }

}

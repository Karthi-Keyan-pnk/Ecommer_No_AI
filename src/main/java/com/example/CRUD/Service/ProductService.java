package com.example.CRUD.Service;

import com.example.CRUD.Module.Product;
import com.example.CRUD.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
       return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Product prod, int id) {
         productRepository.save(prod);
        }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}

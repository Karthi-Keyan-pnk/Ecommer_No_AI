package com.example.CRUD.Controller;

import com.example.CRUD.Module.Product;
import com.example.CRUD.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable int Id)
    {
        return productService.getProductById(Id);
    }
}

package com.example.CRUD.Controller;

import com.example.CRUD.Module.Product;
import com.example.CRUD.Service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        System.out.println(product);
        productService.updateProduct(product,id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
    }
}

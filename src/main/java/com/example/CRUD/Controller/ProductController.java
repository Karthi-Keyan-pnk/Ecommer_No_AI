package com.example.CRUD.Controller;

import com.example.CRUD.Module.Product;
import com.example.CRUD.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProduct")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable int Id)
    {
        return productService.getProductById(Id);
    }

    @GetMapping("/")
    public String home(){
        return "Login Sucessfully!";
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken request){
        return request;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return "added";
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

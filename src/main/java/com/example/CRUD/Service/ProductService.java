package com.example.CRUD.Service;

import com.example.CRUD.Module.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"Kumar", 2.00),
            new Product(2,"Gopi", 1.00),
            new Product(3,"hari", 1.20)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
       return products.stream()
        .filter(p1->p1.getId() == id)
               .findFirst()
                .orElse(new Product(100,"NoItem",0));
        // OR
        // return products.get(id);
    }

    public void updateProduct(Product prod, int id) {
        for(Product p:products){
            if(p.getId()==id){
                p.setPrice(prod.getPrice());
                p.setName(prod.getName());
                break;
            }
        }

    }

    public void deleteProduct(int id) {
        for(Product P:products) {
            if(P.getId()==id){
                products.remove(P);
                break;
            }
        }
    }
}

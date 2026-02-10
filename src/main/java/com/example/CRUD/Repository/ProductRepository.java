package com.example.CRUD.Repository;

import com.example.CRUD.Module.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

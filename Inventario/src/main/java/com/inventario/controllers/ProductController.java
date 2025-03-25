package com.inventario.controllers;

import com.inventario.dtos.ProductDTO;
import com.inventario.entities.CategoryEntity;
import com.inventario.entities.ProductEntity;
import com.inventario.services.CategoryServicesImpl;
import com.inventario.services.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductServicesImpl productServices;

    @Autowired
    private CategoryServicesImpl categoryServices;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productServices.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO product) {
        productServices.save(product);
        return ResponseEntity.ok().body("Product added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product) {
        productServices.update(id, product);
        return ResponseEntity.ok().body("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productServices.deleteById(id);
        return ResponseEntity.ok().body("Product deleted successfully");
    }
}


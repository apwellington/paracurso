package com.inventario.controllers;

import com.inventario.dtos.CategoryDTO;
import com.inventario.services.CategoryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryServicesImpl categoryServices;

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok().body(categoryServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryServices.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO category) {
        categoryServices.save(category);
        return ResponseEntity.ok().body("Category added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category) {
        categoryServices.updateCategory(category, id);
        return ResponseEntity.ok().body("Category updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryServices.deleteById(id);
        return ResponseEntity.ok().body("Category deleted successfully");
    }

}

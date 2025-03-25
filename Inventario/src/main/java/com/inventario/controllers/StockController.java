package com.inventario.controllers;

import com.inventario.dtos.StockDTO;
import com.inventario.entities.StockEntity;
import com.inventario.services.StockServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/stock")
public class StockController {

    @Autowired
    private StockServicesImpl stockServices;

    @GetMapping
    public ResponseEntity<?> getAllStocks() {
        return ResponseEntity.ok(stockServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStockById(@PathVariable Long id) {
        return ResponseEntity.ok(stockServices.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStock(@RequestBody StockDTO stock) {
        stockServices.save(stock);
        return ResponseEntity.ok().body("Stock added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody StockDTO stock) {
        stockServices.updateStock(stock, id);
        return ResponseEntity.ok().body("Stock updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id) {
        stockServices.deleteById(id);
        return ResponseEntity.ok().body("Stock deleted successfully");
    }

}

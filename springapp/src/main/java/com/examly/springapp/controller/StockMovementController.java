package com.examly.springapp.controller;

import com.examly.springapp.model.StockMovement;
import com.examly.springapp.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @PostMapping
    public ResponseEntity<StockMovement> createStockMovement(@RequestBody StockMovement stockMovement) {
        StockMovement savedStockMovement = stockMovementService.saveStockMovement(stockMovement);
        return new ResponseEntity<>(savedStockMovement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StockMovement>> getAllStockMovements() {
        List<StockMovement> stockMovements = stockMovementService.getAllStockMovements();
        return new ResponseEntity<>(stockMovements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        StockMovement stockMovement = stockMovementService.getStockMovementById(id);
        if (stockMovement != null) {
            return new ResponseEntity<>(stockMovement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMovement> updateStockMovement(@PathVariable Long id, @RequestBody StockMovement stockMovement) {
        StockMovement updatedStockMovement = stockMovementService.updateStockMovement(id, stockMovement);
        if (updatedStockMovement != null) {
            return new ResponseEntity<>(updatedStockMovement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
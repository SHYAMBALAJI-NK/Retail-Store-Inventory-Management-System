package com.examly.springapp.controller;

import com.examly.springapp.model.StockEntry;
import com.examly.springapp.service.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-entries")
public class StockEntryController {

    @Autowired
    private StockEntryService stockEntryService;

    @PostMapping
    public ResponseEntity<StockEntry> createStockEntry(@RequestBody StockEntry stockEntry) {
        StockEntry savedStockEntry = stockEntryService.saveStockEntry(stockEntry);
        return new ResponseEntity<>(savedStockEntry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StockEntry>> getAllStockEntries() {
        List<StockEntry> stockEntries = stockEntryService.getAllStockEntries();
        return new ResponseEntity<>(stockEntries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockEntry> getStockEntryById(@PathVariable Long id) {
        StockEntry stockEntry = stockEntryService.getStockEntryById(id);
        if (stockEntry != null) {
            return new ResponseEntity<>(stockEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockEntry> updateStockEntry(@PathVariable Long id, @RequestBody StockEntry stockEntry) {
        StockEntry updatedStockEntry = stockEntryService.updateStockEntry(id, stockEntry);
        if (updatedStockEntry != null) {
            return new ResponseEntity<>(updatedStockEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockEntry(@PathVariable Long id) {
        stockEntryService.deleteStockEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.examly.springapp.controller;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<>(savedWarehouse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse != null) {
            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouse);
        if (updatedWarehouse != null) {
            return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<?> getWarehousesByLocation(@PathVariable String location) {
        List<Warehouse> warehouses = warehouseService.getWarehousesByLocation(location);
        if (warehouses.isEmpty()) {
            return new ResponseEntity<>("No warehouses found at location: " + location, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/location/{location}/name/{name}")
    public ResponseEntity<List<Warehouse>> getWarehousesByLocationAndName(@PathVariable String location, @PathVariable String name) {
        List<Warehouse> warehouses = warehouseService.getWarehousesByLocationAndName(location, name);
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }
}
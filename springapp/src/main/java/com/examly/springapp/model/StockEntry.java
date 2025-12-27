package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockEntryId;

    private int quantity;

    // Getters and Setters
    public Long getStockEntryId() { return stockEntryId; }
    public void setStockEntryId(Long stockEntryId) { this.stockEntryId = stockEntryId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

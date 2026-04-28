package com.foodrescue.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String donor;
    private String item;
    private String expiry;
    private String status;
    private String claimedBy;

    public FoodItem() {}

    public FoodItem(String donor, String item, String expiry, String status, String claimedBy) {
        this.donor = donor;
        this.item = item;
        this.expiry = expiry;
        this.status = status;
        this.claimedBy = claimedBy;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDonor() { return donor; }
    public void setDonor(String donor) { this.donor = donor; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public String getExpiry() { return expiry; }
    public void setExpiry(String expiry) { this.expiry = expiry; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getClaimedBy() { return claimedBy; }
    public void setClaimedBy(String claimedBy) { this.claimedBy = claimedBy; }
}
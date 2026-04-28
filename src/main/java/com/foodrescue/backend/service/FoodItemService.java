package com.foodrescue.backend.service;

import com.foodrescue.backend.model.FoodItem;
import com.foodrescue.backend.repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public List<FoodItem> getAllListings() {
        return repository.findAll();
    }

    public FoodItem createListing(FoodItem item) {
        if (item.getStatus() == null || item.getStatus().isEmpty()) {
            item.setStatus("Available");
        }
        return repository.save(item);
    }

    public FoodItem updateListingStatus(Long id, FoodItem updatedData) {
        return repository.findById(id).map(existingItem -> {
            existingItem.setStatus(updatedData.getStatus());
            existingItem.setClaimedBy(updatedData.getClaimedBy());
            return repository.save(existingItem);
        }).orElseThrow(() -> new RuntimeException("Listing not found with id " + id));
    }

    public void deleteListing(Long id) {
        repository.deleteById(id);
    }
}
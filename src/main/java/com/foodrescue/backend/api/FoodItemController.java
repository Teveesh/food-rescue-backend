package com.foodrescue.backend.api;

import com.foodrescue.backend.model.FoodItem;
import com.foodrescue.backend.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<FoodItem> getAll() {
        return service.getAllListings();
    }

    @PostMapping
    public FoodItem create(@RequestBody FoodItem item) {
        return service.createListing(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> update(@PathVariable Long id, @RequestBody FoodItem item) {
        try {
            return ResponseEntity.ok(service.updateListingStatus(id, item));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteListing(id);
        return ResponseEntity.noContent().build();
    }
}
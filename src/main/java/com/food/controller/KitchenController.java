package com.food.controller;

import com.food.model.Kitchen;
import com.food.service.KitchenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    private final KitchenService kitchenService;

    public KitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping
    public ResponseEntity<List<Kitchen>> getAllKitchens() {
        return ResponseEntity.ok(kitchenService.getAllKitchens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> getKitchenById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(kitchenService.getKitchenById(id));
    }

    @PostMapping
    public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
        var savedKitchen = kitchenService.save(kitchen);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(savedKitchen.getId()).toUri();
        return ResponseEntity.created(uri).body(savedKitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(@PathVariable("id") Long id, @RequestBody Kitchen kitchen) {
        return ResponseEntity.ok(kitchenService.update(id, kitchen));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        kitchenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.food.service;

import com.food.model.Kitchen;
import com.food.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitchenService {

    private final KitchenRepository kitchenRepository;

    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @Transactional(readOnly = true)
    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Kitchen getKitchenById(Long id) {
        return kitchenRepository.findById(id).orElseThrow(() -> new RuntimeException("Kitchen not found"));
    }
}

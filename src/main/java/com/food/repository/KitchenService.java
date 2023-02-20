package com.food.repository;

import com.food.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenService extends JpaRepository<Kitchen, Long> {
}

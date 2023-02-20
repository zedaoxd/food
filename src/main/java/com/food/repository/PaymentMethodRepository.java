package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<com.food.model.PaymentMethod, Long> {
}

package com.food.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "restaurant")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "shipping_fee", nullable = false)
    private BigDecimal shippingFee;
}

package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "orderProduct")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column( name = "orderProductId", unique = true, nullable = false)
    @NotBlank
    String orderProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    @NotNull(message = "orderId cannot be null")
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    @NotNull(message = "productId cannot be null")
    Products product;

    @Column(name="quantity", nullable = false, columnDefinition = "INT DEFAULT 1")
    @NotNull
    @Min(value = 1, message = "quantity must be at least 1")
    Integer quantity;
}

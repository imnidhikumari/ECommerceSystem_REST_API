package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="product")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="cartProductId", unique=true, nullable = false)
    @NotNull
    Double cartProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cartId", nullable = false)
    @NotNull(message = "cartId must not be null")
    Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="productId", nullable = false)
    @NotNull(message = "productId must not be null")
    Product product;

    @Column(name="quantity", nullable = false, columnDefinition = "INT DEFAULT 1")
    @NotNull
    @Min(value = 1, message = "quantity must be at least 1")
    Integer quantity;
}

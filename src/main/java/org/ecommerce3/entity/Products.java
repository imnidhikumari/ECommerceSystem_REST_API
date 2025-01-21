package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="productId", unique=true, nullable = false)
    @NotBlank( message = "productId must not be blank")
    String productId;

    @Column(name="name", nullable = false)
    @NotBlank
    String name;

    @Column(name="description", nullable = false)
    @NotBlank
    String description;

    @Column(name="price", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be at least 0")
    BigDecimal price;

    @Column(name="stockQuantity", columnDefinition = "INT DEFAULT 0")
    @NotNull
    @Min(value = 0, message = "Stock quantity must be at least 0")
    Integer stockQuantity;
}

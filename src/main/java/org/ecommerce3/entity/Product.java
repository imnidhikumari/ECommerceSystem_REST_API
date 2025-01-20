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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="productId", unique=true, nullable = false)
    @NotNull
    Double productId;

    @Column(name="name", nullable = false)
    @NotBlank
    String name;

    @Column(name="description", nullable = false)
    @NotBlank
    String description;

    @Column(name="price", nullable = false)
    @NotNull
    @Min(value = 0, message = "Price must be at least 0")
    Double price;

    @Column(name="stockQuantity", nullable = false, columnDefinition = "INT DEFAULT 0")
    @NotNull
    @Min(value = 0, message = "Stock quantity must be at least 0")
    Integer stockQuantity;
}

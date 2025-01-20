package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cart")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="cartId", unique=true, nullable = false)
    @NotNull
    Double cartId;

    @ManyToOne(fetch = FetchType.LAZY) // As many carts can belong to one user
    @JoinColumn(name = "userId", nullable = false)
    Users user;

}

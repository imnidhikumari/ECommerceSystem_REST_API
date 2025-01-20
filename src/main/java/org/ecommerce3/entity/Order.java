package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table( name = "order" )
@FieldDefaults( level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "orderId", unique = true, nullable = false)
    @NotNull
    String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "userId cannot be null")
    Users user;

    @Column(name = "orderDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // Automatically sets the current timestamp
    Date orderDate;

    @Column(name = "status", nullable = false, length = 100, columnDefinition = "VARCHAR(100) DEFAULT 'Pending'")
    @NotBlank
    String Status;
}

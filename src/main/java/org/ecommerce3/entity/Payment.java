package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.ecommerce3.enums.PaymentStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "paymentId", unique = true, nullable = false)
    @NotBlank(message = "paymentId cannot be blank")
    String paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    @NotNull(message = "orderId cannot be null")
    Order order;

    @Column(name = "paymentDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // Automatically sets the current timestamp
    Date paymentDate;

    @Column(name="amount", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "amount is mandatory")
    @Min(value = 0, message = "amount must be at least 0")
    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentStatus", nullable = false, length = 50)
    @NotNull(message = "Payment status cannot be null")
    PaymentStatus paymentStatus = PaymentStatus.PENDING; //Default Value
}

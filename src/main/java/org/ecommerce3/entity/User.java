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
@Table(name="user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="userId", nullable = false)
    @NotNull
    Double userId;

    @Column(name="name", nullable = false)
    @NotBlank
    String name;

    @Column(name="email", nullable = false)
    @NotBlank
    String email;

    @Column(name="password", unique=true, nullable = false)
    @NotBlank
    String password;

    @Column(name="createdAt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date createdAt;
}

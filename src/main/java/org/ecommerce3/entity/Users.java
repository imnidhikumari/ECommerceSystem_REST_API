package org.ecommerce3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="users")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="userId", nullable = false)
    @NotBlank
    String userId;

    @Column(name="name", nullable = false)
    @NotBlank
    String name;

    @Column(name="email", unique = true, nullable = false)
    @NotBlank
    @Email(message = "Invalid email format")
    String email;

    @Column(name="password", unique=true, nullable = false)
    @NotBlank
    String password;

    @Column(name="createdAt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date createdAt;
}

package com.avinash.BankingAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30)
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 30)
    private String password;

    @Email
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

//    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;

}

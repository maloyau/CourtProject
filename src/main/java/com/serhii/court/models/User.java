package com.serhii.court.models;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "first_name")
    @NotEmpty(message = "Введіть ім'я користувача")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Введіть прізвище користувача")
    private String lastName;
    @Column(name = "username")
    @NotEmpty(message = "Введіть логін користувача")
    private String username;
    @Column(name = "email")
    @Email(message = "Введіть валідний email")
    @NotEmpty(message = "Введіть email")
    private String email;
    @Column(name = "password")
    @Transient
    @NotEmpty(message = "Введіть пароль")
    private String password;
    @Column(name = "active")
    private boolean active;
    @ElementCollection
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}

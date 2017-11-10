package com.serhii.court.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends AbstractEntity{
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "username", nullable = false, length = 255, unique = true)
    private String username;
    @Basic
    @Column(name = "firstname", nullable = true, length = 255)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = true, length = 255)
    private String lastname;
    @Basic
    @Column(name = "active", nullable = false,columnDefinition = "BIT DEFAULT 1")
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
    @Embedded
    private ContactInfo contactInfo;
}

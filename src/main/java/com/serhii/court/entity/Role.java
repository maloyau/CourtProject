package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic
    @Column(name = "role_name", nullable = false, length = 255)
    private String roleName;
}

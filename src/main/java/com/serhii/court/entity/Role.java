package com.serhii.court.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;
}

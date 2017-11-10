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
@Table(name = "participants")
public class Participant extends AbstractEntity{
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private ContactInfo contactInfo;
}

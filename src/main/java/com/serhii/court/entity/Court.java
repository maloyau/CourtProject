package com.serhii.court.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "courts")
public class Court extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "court_id", nullable = false)
    private long courtId;
    @Basic
    @Column(name = "court_name", nullable = false, length = 255)
    private String courtName;
    @Basic
    @Column(name = "court_address", nullable = true, length = 255)
    private String courtAddress;
}

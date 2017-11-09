package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courts")
public class Court {
    @Id
    @Column(name = "court_id", nullable = false)
    private long courtId;
    @Basic
    @Column(name = "court_name", nullable = false, length = 255)
    private String courtName;
    @Basic
    @Column(name = "court_address", nullable = true, length = 255)
    private String courtAddress;
}

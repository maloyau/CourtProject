package com.serhii.court.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "courts")
@Data
public class Court {
    @Id
    @GeneratedValue
    @Column(name = "court_id")
    private long courtId;
    @Column(name = "court_name")
    private String name;
}

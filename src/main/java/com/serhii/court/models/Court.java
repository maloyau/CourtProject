package com.serhii.court.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courts")
@Data
public class Court {
    @Id
    @GeneratedValue
    private long id;
    private String name;
}

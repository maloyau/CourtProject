package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String postcode;
    private String country;
    private String region;
    private String district;
    private String city;
    private String street;
    private String building;
    private String room;
}

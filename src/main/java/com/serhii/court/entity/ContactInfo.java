package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ContactInfo {
    private String email;
    private String phone;
}

package com.serhii.court.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private long userId;
    private String email;
    private String password;
    private String username;
    private String firstname;
    private String lastname;
    private boolean active;
    private Set<String> roles;
}

package com.serhii.court.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}

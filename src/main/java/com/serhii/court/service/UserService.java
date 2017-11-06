package com.serhii.court.service;

import com.serhii.court.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    void delete(User user);
    List<User> findAll();
}

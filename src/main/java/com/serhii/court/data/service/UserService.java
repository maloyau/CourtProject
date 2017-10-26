package com.serhii.court.data.service;

import com.serhii.court.data.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    User findById(long id);
    User findByUsername(String username);
    List<User> findAll();
}

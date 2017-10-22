package com.serhii.court.services;

import com.serhii.court.models.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    User findOne(long id);
    List<User> findAll();
}

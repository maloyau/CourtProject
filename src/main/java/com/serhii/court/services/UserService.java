package com.serhii.court.services;

import com.serhii.court.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    User findById(long id);
    User findByUsername(String username);
    List<User> findAll();
}

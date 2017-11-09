package com.serhii.court.service.impl;


import com.serhii.court.entity.Role;
import com.serhii.court.entity.User;
import com.serhii.court.repository.RoleRepository;
import com.serhii.court.repository.UserRepository;
import com.serhii.court.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User create(User user) {
        if (user.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                if (roleRepository.findByName(role.getName()) == null) {
                    roleRepository.saveAndFlush(role);
                }
            }
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

package com.serhii.court.service.impl;

import com.serhii.court.model.Role;
import com.serhii.court.model.User;
import com.serhii.court.repository.RoleRepository;
import com.serhii.court.repository.UserRepository;
import com.serhii.court.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public User create(User user) {
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                if (roleRepository.findByRoleName(role.getRoleName()) == null) {
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

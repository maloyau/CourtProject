package com.serhii.court.controller;

import com.serhii.court.dto.UserDto;
import com.serhii.court.entity.Cause;
import com.serhii.court.entity.Role;
import com.serhii.court.entity.User;
import com.serhii.court.repository.RoleRepository;
import com.serhii.court.service.CauseService;
import com.serhii.court.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AppController {

    private CauseService causeService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCauseService(CauseService causeService) {
        this.causeService = causeService;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_ADMIN"));
        User user = new User();
        user.setUsername("admin");
        user.setPassword("12345678");
        user.setRoles(roles);
        userService.create(user);
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {

        List<Cause> causes = causeService.findAll();
        return new ModelAndView("hello", "causes", causes);
    }
/*
    @RequestMapping(value = "/hello/users", method = RequestMethod.GET)
    public ModelAndView users() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user: userService.findAll()) {
            usersDto.add(modelMapper.map(user, UserDto.class));
        }
        return new ModelAndView("hello", "users", usersDto);
    }*/

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

}

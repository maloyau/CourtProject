package com.serhii.court.controller;

import com.serhii.court.dto.UserDto;
import com.serhii.court.entity.Cause;
import com.serhii.court.entity.User;
import com.serhii.court.service.CauseService;
import com.serhii.court.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CauseService causeService;

    @Autowired
    private UserService userService;

    private static ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        List<Cause> causes = causeService.findAll();
        return new ModelAndView("hello", "cases", causes);
    }

    @RequestMapping(value = "/hello/users", method = RequestMethod.GET)
    public ModelAndView users() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user: userService.findAll()) {
            usersDto.add(modelMapper.map(user, UserDto.class));
        }
        return new ModelAndView("hello", "users", usersDto);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

}

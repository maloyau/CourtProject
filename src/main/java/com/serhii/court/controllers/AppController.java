package com.serhii.court.controllers;

import com.serhii.court.services.CourtCaseService;
import com.serhii.court.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(Model model) {
        model.addAttribute("auth", true);
        return "index";
    }
}

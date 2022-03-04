package com.alkemy.challenge.controllers;

import javax.servlet.http.HttpSession;

import com.alkemy.challenge.models.UserDB;
import com.alkemy.challenge.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class PrivateController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){
        String username = auth.getName();

        if(session.getAttribute("user") == null){
            UserDB user = userService.findByUsername(username);
            user.setPassword(null);
            session.setAttribute("user",user);
        }
        return "index";
    }

}

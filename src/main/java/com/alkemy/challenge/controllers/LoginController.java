package com.alkemy.challenge.controllers;

import com.alkemy.challenge.models.UserDB;
import com.alkemy.challenge.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDB());

        return "login";
    }

    @GetMapping("/auth/register")
    private String registerFrom(Model model) {
        model.addAttribute("user", new UserDB());
        
        return "register";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute UserDB user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/register";
        } else {
            model.addAttribute("user", userService.register(user));
        }

        return "redirect:/auth/login";
    }
}

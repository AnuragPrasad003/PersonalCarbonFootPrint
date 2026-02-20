package com.anupd.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anupd.entity.User;
import com.anupd.service.AuthService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(User u) {
        authService.register(u);
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(String email, String password, HttpSession session) {

        User user = authService.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        }

        return "login";
    }

}

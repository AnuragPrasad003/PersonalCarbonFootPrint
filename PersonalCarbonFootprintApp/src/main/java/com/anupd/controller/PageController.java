package com.anupd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anupd.entity.CarbonLog;
import com.anupd.entity.User;
import com.anupd.repository.CarbonLogRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
	
	@Autowired
    private CarbonLogRepository carbonLogRepository;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/registerPage")
    public String register() {
        return "register";
    }

    
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        List<CarbonLog> logs = carbonLogRepository.findByUser(user);

        double total = logs.stream()
                .mapToDouble(CarbonLog::getTotalEmission)
                .sum();

        model.addAttribute("logs", logs);
        model.addAttribute("totalEmission", total);

        return "dashboard";
    }



    @GetMapping("/carbonPage")
    public String carbon() {
        return "carbon";
    }

    @GetMapping("/surveyPage")
    public String survey() {
        return "survey";
    }
}

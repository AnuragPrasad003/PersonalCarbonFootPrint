package com.anupd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anupd.entity.CarbonLog;
import com.anupd.entity.User;
import com.anupd.repository.CarbonLogRepository;
import com.anupd.service.CarbonService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carbon")
public class CarbonLogController {

    @Autowired
    private CarbonLogRepository carbonLogRepository;

    @Autowired
    private CarbonService carbonService;
    
    @PostMapping("/add")
    public String add(CarbonLog c, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        c.setDate(java.time.LocalDate.now());
        // Use values directly from form, just sum them up
        c.setTotalEmission(c.getTransportEmission() + c.getFoodEmission() + c.getEnergyEmission());
        c.setUser(user);
        carbonLogRepository.save(c);

        return "redirect:/dashboard";
    }
}
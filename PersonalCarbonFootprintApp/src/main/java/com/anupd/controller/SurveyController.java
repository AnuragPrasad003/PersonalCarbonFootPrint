package com.anupd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.anupd.entity.CarbonLog;
import com.anupd.entity.Survey;
import com.anupd.entity.User;
import com.anupd.repository.CarbonLogRepository;
import com.anupd.repository.SurveyRepository;
import com.anupd.service.CarbonService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private CarbonLogRepository carbonLogRepository;

    @Autowired
    private CarbonService carbonService;

    @PostMapping("/save")
    public String save(Survey s, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        // Attach user and save survey
        s.setUser(user);
        surveyRepository.save(s);

        // Calculate individual emissions
        double t;
        switch (s.getTransportMode().toLowerCase()) {
            case "car":   t = 2.5; break;
            case "bike":  t = 1.5; break;
            case "bus":   t = 1.0; break;
            case "train": t = 0.5; break;
            case "cycle":
            case "walk":  t = 0.0; break;
            default:      t = 1.0; break;
        }

        double f;
        switch (s.getDietType().toLowerCase()) {
            case "nonveg": f = 2.5; break;
            case "veg":    f = 1.0; break;
            case "vegan":  f = 0.5; break;
            default:       f = 1.0; break;
        }

        double e = s.getEnergyUsage() * 0.5;

        // Create and save carbon log
        CarbonLog log = new CarbonLog();
        log.setDate(java.time.LocalDate.now());
        log.setTransportEmission(t);
        log.setFoodEmission(f);
        log.setEnergyEmission(e);
        log.setTotalEmission(t + f + e);
        log.setUser(user);
        carbonLogRepository.save(log);

        return "redirect:/dashboard";
    }
}
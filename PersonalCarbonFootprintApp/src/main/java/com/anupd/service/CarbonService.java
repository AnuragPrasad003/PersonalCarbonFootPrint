package com.anupd.service;

import org.springframework.stereotype.Service;

@Service
public class CarbonService {
	
	public double calculateEmission(String transport,String diet,double energy) {
		

        // Transport emission based on mode
        double t;
        switch (transport.toLowerCase()) {
            case "car":        t = 2.5; break;
            case "bike":       t = 1.5; break;
            case "bus":        t = 1.0; break;
            case "train":      t = 0.5; break;
            case "cycle":
            case "walk":       t = 0.0; break;
            default:           t = 1.0; break;
        }

        // Food emission based on diet
        double f;
        switch (diet.toLowerCase()) {
            case "nonveg":     f = 2.5; break;
            case "veg":        f = 1.0; break;
            case "vegan":      f = 0.5; break;
            default:           f = 1.0; break;
        }

        // Energy emission
        double e = energy * 0.5;

        return t + f + e;
	}
	

}

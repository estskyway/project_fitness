package com.the_glory.project_fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.the_glory.project_fitness.service.FitnessService;

@Controller
public class  gym_loginController {
    @Autowired
    FitnessService fitnessService;

    @GetMapping({"/Gym_Login"})
    public ModelAndView Login(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/Fitness/GYM/gym_login.jsp";
        modelAndView.setViewName(viewName);
        
        return modelAndView;
    }
}

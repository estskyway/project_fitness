package com.the_glory.project_fitness.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.the_glory.project_fitness.security.JoinsService;

import com.the_glory.project_fitness.service.CarInforsService;
import com.the_glory.project_fitness.service.CommonService;


@Controller
public class JoinController {

    @Autowired
    
    JoinsService usersService;

    @GetMapping({ "/Join" })
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/views/Fitness/Join/Join.jsp");
        return modelAndView;
    }

    @PostMapping({ "/joininsert" })
    public ModelAndView Joininsert(@RequestParam Map datamap, ModelAndView modelAndView) {
        Object result = usersService.insertWithAuths(datamap);
        modelAndView.addObject("datamap", datamap);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/WEB-INF/views/Fitness/GYM/gym.jsp");
        return modelAndView;
    }
}
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

import com.the_glory.project_fitness.service.SearchService;



@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping({"/Search"})
    public ModelAndView main(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = searchService.selectSearch(params);

        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/WEB-INF/views/Fitness/Search/Search.jsp");
        return modelAndView;
    }
}
    

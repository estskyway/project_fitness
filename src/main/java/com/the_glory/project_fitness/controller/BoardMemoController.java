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

import com.the_glory.project_fitness.service.CarInforsService;
import com.the_glory.project_fitness.service.CommonService;
import com.the_glory.project_fitness.service.NoticeService;

@Controller
public class BoardMemoController {
    @Autowired
    NoticeService noticeService;

    @GetMapping({"/boardmemo"})
    public ModelAndView main(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = noticeService.selectAll(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        // modelAndView.addObject("params", "result");
        // modelAndView.setViewName("/WEB-INF/views/carinfor/list_map.jsp");
        modelAndView.setViewName("/WEB-INF/views/Fitness/Board/BoardMemo.jsp");
        return modelAndView;
    }

    @PostMapping("/memoinsertAndSelectSearch")
    public ModelAndView insertAndSelectSearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = noticeService.insertAndSelectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        // modelAndView.setViewName("/WEB-INF/views/carinfor/list_map.jsp");
        modelAndView.setViewName("/WEB-INF/views/Fitness/Notice/NoticeLogin.jsp");
        return modelAndView;
    }
}

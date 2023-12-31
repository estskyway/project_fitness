package com.the_glory.project_fitness.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping({"/login2"})     // 로그인 폼 작성
    public ModelAndView loginForm(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/Fitness/Login/Login2.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @GetMapping({"/logout"})     // 로그아웃 폼 작성
    public ModelAndView logoutForm(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/Fitness/Logout/Logout.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
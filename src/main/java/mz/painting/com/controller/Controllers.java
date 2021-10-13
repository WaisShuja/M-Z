package mz.painting.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class Controllers {

    @GetMapping("/service")
    public ModelAndView service(){
        System.out.println("User is in Service Page");
        return new ModelAndView("service");
    }

    @GetMapping("/about")
    public ModelAndView about(){
        System.out.println("User is in About page");
        return new ModelAndView("about");
    }

    @GetMapping("/greeting")
    public ModelAndView service1(HttpSession session){
        System.out.println("User is in greeting Page");
//       End User Session
        session.setMaxInactiveInterval(1*60);
        return new ModelAndView("greeting");
    }

    @GetMapping("/mzFacebook")
    public String redirectFb(){
        return "redirect:https://www.facebook.com/m.z.painting.au/";
    }
/*
https://www.facebook.com/m.z.painting.au/

*/ }
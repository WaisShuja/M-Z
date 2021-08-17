package mz.painting.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {

    @GetMapping("/home")
    public ModelAndView home(){
        System.out.println("User is in Homepage");
        return new ModelAndView("index");
    }

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

}

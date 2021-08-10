package mz.painting.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {

    @GetMapping("/home")
    public ModelAndView home(){
        var model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @GetMapping("/service")
    public ModelAndView service(){
        return new ModelAndView("service");
    }

    @GetMapping("/about")
    public ModelAndView about(){
        return new ModelAndView("about");
    }

    @GetMapping("/contact")
    public ModelAndView contact(){
        return new ModelAndView("contact");
    }
}

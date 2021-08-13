package mz.painting.com.controller;

import mz.painting.com.entities.Customer;
import mz.painting.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

 public class SavingUser{

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/registerUser")
    public ModelAndView user(@ModelAttribute Customer customer, ModelMap model){
        System.out.println("User in registration page..");
        userRepository.save(customer);
        model.addAttribute("saveUser", customer);
        return new ModelAndView("index");
    }
}

package mz.painting.com.controller;

import mz.painting.com.entities.Customer;
import mz.painting.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

 public class SavingUser{

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/registerUser")
    public ModelAndView user(@Valid @ModelAttribute Customer customer, BindingResult result, ModelMap model){
        System.out.println("User in registration page..");
        userRepository.save(customer);
        model.addAttribute("saveUser", customer);
        return new ModelAndView("service");
    }
    @GetMapping("/registerUser")
    public ModelAndView getUser(@Valid @ModelAttribute Customer customer, BindingResult result, ModelMap model){
        System.out.println("User in registration page..");
        userRepository.save(customer);
        model.addAttribute("saveUser", customer);
        return new ModelAndView("service");
    }

}

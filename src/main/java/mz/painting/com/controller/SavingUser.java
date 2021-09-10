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

    @GetMapping("/index")
    public String addUser(Model model){
        model.addAttribute("user", new Customer());
        return "index";

    }


    @PostMapping("/registerUser")
    public String userRegistration(@ModelAttribute Customer user, Model model){
        System.out.println("User in registration page..");
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/index";

    }

}

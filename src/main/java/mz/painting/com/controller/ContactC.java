package mz.painting.com.controller;

import mz.painting.com.entities.Customer;
import mz.painting.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactC {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/contact")
    public String contactUs(Model model){
        model.addAttribute("data", new Customer());
        return "contact";
    }

    @PostMapping("/contacting")
    public String contacting(@ModelAttribute Customer customer, Model model){
        System.out.println("User registered!");
        userRepository.save(customer);
        model.addAttribute("data", customer);
        return "contact";
    }

}

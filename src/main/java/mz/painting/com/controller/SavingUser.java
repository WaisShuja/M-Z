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

    @GetMapping("/home")
    public String addUser(Model model){
        model.addAttribute("user", new Customer());
        return "index";

    }


    @PostMapping("/registerUser")
    public String userRegistration(@Valid @ModelAttribute("user") Customer user, BindingResult result, Model model){

         if(result.hasErrors()) {
             System.out.println("User entered false info!");
             return "index";
         }

        System.out.println("User's been registered..");
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/home";

    }

}

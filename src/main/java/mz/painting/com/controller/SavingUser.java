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

    @GetMapping("/addUser")
    public ModelAndView addUser(ModelMap model){
        System.out.println("Adding User in registration page..");
        model.addAttribute("user", new Customer());
        return new ModelAndView("service");

    }


    @PostMapping("/registerUser")
    public ModelAndView userRegistration(@ModelAttribute("user") Customer user, ModelMap model){
        System.out.println("User in registration page..");
        model.addAttribute("user", user);
        userRepository.save(user);
        return new ModelAndView("redirect:/service");

   /* @RequestMapping(value = "/person/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("person", new Customer());
        return "add-person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String processAdd(@Valid @ModelAttribute("person") Customer person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-person";
        }

        return "person-added-successfully";
      }
      */


    }

}

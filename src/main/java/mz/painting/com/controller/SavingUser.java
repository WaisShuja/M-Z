package mz.painting.com.controller;

import mz.painting.com.entities.Customer;
import mz.painting.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
 public class SavingUser{

    @Autowired
    private UserRepository userRepository;


//   Converting String value (Date ) to a Date Object
    @InitBinder
    public void binder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Date.class, "date", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"),true));
    }



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

        System.out.println("User's placed a request !..");
        System.out.println("Request Date: "+ user.getDate());
//        model.addAttribute("user", user);
//        model.addAttribute("registerSuccess", "Thank you for contacting us, we will get back to you soon ");
        model.addAttribute("user", user.getName());
        userRepository.save(user);
        return "redirect:/service";

    }

}

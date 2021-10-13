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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

@Controller
 public class HomePageController {

    @Autowired
    private UserRepository userRepository;


//   Converting String value (Date ) to a Date Object
    @InitBinder
    public void binder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Date.class, "date", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"),true));
    }

    @GetMapping("/home")
    public String addUser(Model model, HttpSession session) {
        session.setMaxInactiveInterval(10*60);
        model.addAttribute("user", new Customer());
        return "index";
    }


    @PostMapping("/registerUser")
    public Callable <String> userRegistration(@Valid @ModelAttribute("user") Customer user,
                                              BindingResult result, Model model, HttpServletRequest request, HttpSession session){


        System.out.println("Is Async enabled ? " + request.isAsyncSupported());
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        System.out.println("A customer named : " + user.getName() + " requests for a quote !..");
        System.out.println("Date: "+ new Date() + " Request Date : " + user.getDate());


        return()->{

            if(result.hasErrors()) {
             System.out.println("User entered false info!");
             return "index";
         }

            Thread.sleep(3000);
            System.out.println("Thread form MVC T-E : "+ Thread.currentThread().getName());

//          Display this session in RedirectedPage
            session.setAttribute("customer", user.getName());
            userRepository.save(user);
            return "redirect:/greeting";
        };
    }
}

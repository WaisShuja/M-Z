package mz.painting.com.controller;
import mz.painting.com.entities.Customer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class DefaultMVController {

    @ModelAttribute("user")
    public Customer customer(){
        return new Customer();
    }

}

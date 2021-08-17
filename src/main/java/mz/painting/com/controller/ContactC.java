package mz.painting.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactC {

    @GetMapping("/contactUs")
    public String contactUs(){
        return "";
    }

}

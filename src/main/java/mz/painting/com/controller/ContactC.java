package mz.painting.com.controller;

import mz.painting.com.entities.Customer;
import mz.painting.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

@Controller
public class ContactC {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    @GetMapping("/contact")
    public String contactUs(Model model){
        model.addAttribute("data", new Customer());
        return "contact";
    }

    @PostMapping("/contacting")
    public DeferredResult<String> contacting(@ModelAttribute Customer customer, Model model, HttpServletRequest request){

         var stringDeferredResult = new DeferredResult<String>();
        System.out.println("Is Async Enabled ? : " + request.isAsyncSupported());
        System.out.println("Servlet C Thread: " + Thread.currentThread().getName());

          asyncTaskExecutor.execute(() -> {
              try {
                  Thread.sleep(3000);
              }catch(InterruptedException e){
                  System.out.println(e.getMessage());
              }
              System.out.println("MVC T-E Thread: " + Thread.currentThread().getName());
              System.out.println("User registered!");
              userRepository.save(customer);
              model.addAttribute("data", customer);
              stringDeferredResult.setResult("service");

          });
        return stringDeferredResult;
    }

}

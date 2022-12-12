package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration.view")
    public String listOfCarPage(){
        return "registration";
    }
}

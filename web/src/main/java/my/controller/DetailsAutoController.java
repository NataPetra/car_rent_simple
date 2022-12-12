package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailsAutoController {

    @GetMapping("/details_auto.view")
    public String listOfCarPage(){
        return "details_auto";
    }
}

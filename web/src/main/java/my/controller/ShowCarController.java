package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowCarController {

    @GetMapping("/list_of_cars.view")
    public String listOfCarPage(){
        return "list_of_cars";
    }

}

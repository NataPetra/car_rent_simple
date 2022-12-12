package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateCarController {

    @GetMapping("/update_car.view")
    public String listOfCarPage(){
        return "update_car";
    }

}

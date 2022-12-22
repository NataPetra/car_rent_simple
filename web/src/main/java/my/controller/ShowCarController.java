package my.controller;

import my.service.auto_services.ListOfAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ShowCarController {

    @Autowired
    private ListOfAutoService listOfAutoService;

    @GetMapping("/list_cars.view")
    public ModelAndView listOfCar(){
        System.out.println("Call list of cars");
        return new ModelAndView(
                "list_cars",
                Map.of("carsList", listOfAutoService.showAutoBriefly())
        );
    }

    @GetMapping("/list_cars/{pageId}.view")
    public ModelAndView listOfCarPage(@PathVariable int pageId){
        System.out.println("Call list of cars");
        int total=5;
        List list=listOfAutoService.showAutoPage(pageId-1,total);
        return new ModelAndView(
                "list_cars",
                Map.of("carsList", list)
        );
    }


}

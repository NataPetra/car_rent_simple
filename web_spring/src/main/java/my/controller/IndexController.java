package my.controller;

import my.service.auto_services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private ModelService modelService;

    @GetMapping({"/", "/index.html"})
    public ModelAndView homePage() {
        System.out.println("Call home page");
        return new ModelAndView("index",
                Map.of("models", modelService.findAllNames()));
    }

}

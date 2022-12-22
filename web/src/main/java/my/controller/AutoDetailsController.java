package my.controller;

import my.service.auto_services.AutoDetailsService;
import my.service.auto_services.AutoPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AutoDetailsController {

    @Autowired
    private AutoDetailsService autoDetailsService;

    @Autowired
    private AutoPictureService autoPictureService;

    @GetMapping("/details_auto/{car.number}.view")
    public ModelAndView showAutoDetails(@PathVariable("car.number") Integer id){
        return new ModelAndView("details_auto",
                Map.of("autoDetailsBean", autoDetailsService.showAllInfAutoById(id)));
    }


    @ResponseBody
    @GetMapping("/image/{car.id}/picture.jpg")
    public byte[] getImage(@PathVariable("car.id") Integer id) {
        System.out.println("Call getImage: " + id);
        return autoPictureService.findById(id).getPicture();
    }
}

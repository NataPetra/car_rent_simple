package my.controller;

import my.beans.AutoCommonBean;
import my.service.auto_services.AutoService;
import my.service.auto_services.DeleteAutoService;
import my.service.auto_services.UpdateAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DeleteCarController {

    @Autowired
    private UpdateAutoService updateAutoService;
    @Autowired
    private AutoService autoService;
    @Autowired
    private DeleteAutoService deleteAutoService;

    @GetMapping("/delete_car/{car.id}.view")
    public ModelAndView deleteCarPage(@PathVariable("car.id") Integer id){
        return new ModelAndView("delete_car",
                Map.of("autoCommonBean", updateAutoService.getAutoCommonBeanById(id)));
    }

    @GetMapping("/delete_confirm/{car.id}.action")
    public ModelAndView deleteConfirmCarPage(@PathVariable("car.id") Integer id){
        AutoCommonBean autoCommonBean = deleteAutoService.saveInf(id);
        deleteAutoService.deleteAllInf(id);
        return new ModelAndView("delete_confirm_car",
                Map.of("autoBean", autoCommonBean));
    }
}

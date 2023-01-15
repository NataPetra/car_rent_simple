package my.controller;

import lombok.SneakyThrows;
import my.beans.AutoCommonBean;
import my.service.auto_services.UpdateAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UpdateCarController {

    @Autowired
    private UpdateAutoService updateAutoService;

    @GetMapping("/update_car/{car.id}.view")
    public ModelAndView updateCarPage(@PathVariable("car.id") Integer id) {
        return new ModelAndView("update_car",
                Map.of("autoCommonBean", updateAutoService.getAutoCommonBeanById(id)));
    }
//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<AutoCommonBean> autoCommonBean = restTemplate.getForEntity(
//            "http://localhost:8080/car_rent/update_car/{car.id}.view",
//            AutoCommonBean.class);
//        return new ModelAndView("update_car",
//                                Map.of("autoCommonBean", autoCommonBean));

    @PostMapping("/update_car/{car.id}.action")
    @SneakyThrows
    public String updateAutoComm(@PathVariable("car.id") Integer id,
                                 AutoCommonBean autoCommonBean) {
        System.out.println("Call update Auto controller");
        updateAutoService.updateAutoCommon(autoCommonBean, id);
        return "redirect:/list_cars.view";
    }

    @PostMapping("/update_car_picture/{car.id}.action")
    @SneakyThrows
    public String updateAutoPicture(@RequestParam("picture") MultipartFile file, @PathVariable("car.id") Integer id) {
        System.out.println("Call update Picture controller");
        updateAutoService.updateAutoCommonWithPicture(file.getBytes(), id);
        return "redirect:/list_cars.view";
    }

}

package my.rest;

import my.beans.AutoCommonBean;
import my.service.auto_services.UpdateAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/update_car")
public class AutoBeanRestController {

    @Autowired
    private UpdateAutoService updateAutoService;

    @GetMapping("/{car.id}.view")
    public ResponseEntity<AutoCommonBean> getBeanById(@PathVariable("car.id") Integer id) {
        AutoCommonBean bean = updateAutoService.getAutoCommonBeanById(id);
        return new ResponseEntity<>(
                bean,
                HttpStatus.OK);
    }
}


//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<AutoCommonBean> autoCommonBean = restTemplate.getForEntity(
//            "http://localhost:8080/car_rent/update_car/{car.id}.view",
//            AutoCommonBean.class);
//        return new ModelAndView("update_car",
//                                Map.of("autoCommonBean", autoCommonBean));

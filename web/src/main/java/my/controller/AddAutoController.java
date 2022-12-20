package my.controller;

import lombok.SneakyThrows;
import my.beans.AutoCommonBean;
import my.service.AddAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddAutoController {

    @Autowired
    private AddAutoService addAutoComm;

    @GetMapping("/create_car.view")
    public String showAddAutoCommPage() {
        return "create_car";
    }

    @PostMapping("/create_car.action")
    @SneakyThrows
    public String addAutoComm(AutoCommonBean autoCommonBean){
        //System.out.println("Call addAuto: " + autoCommonBean);
        addAutoComm.addCommonAuto(autoCommonBean);
        return "redirect:/create_car.view";

    }

//    @PostMapping("/create_car.action")
//    @SneakyThrows
//    public String addAutoComm(@RequestParam("picture") MultipartFile file, AutoCommonBean autoCommonBean){
//        addAutoComm.addCommonAuto(autoCommonBean, file.getBytes());
//        return "redirect:/create_car.view";
//
//    }

}

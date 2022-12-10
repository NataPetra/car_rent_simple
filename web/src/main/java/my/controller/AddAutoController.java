package my.controller;

import my.beans.AutoCommonBean;
import my.service.AddAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddAutoController {

    @Autowired
    private AddAutoService addAutoComm;

    @GetMapping("/create_car.action")
    public String showAddAutoCommPage() {
        return "create_car";
    }

    @PostMapping("/create_car.action")
    public String addAutoComm(AutoCommonBean autoCommonBean){
        addAutoComm.addCommonAuto(autoCommonBean);
        return "create_car";

    }

}

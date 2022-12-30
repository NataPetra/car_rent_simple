package my.controller;

import lombok.SneakyThrows;
import my.beans.AutoCommonBean;
import my.service.auto_services.AddAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class AddAutoController {

    @Autowired
    private AddAutoService addAutoComm;

    @GetMapping("/create_car.view")
    public String showAddAutoCommPage(Model model) {
        model.addAttribute("autoCommon", new AutoCommonBean());
        return "create_car";
    }

    @PostMapping("/create_car.action")
    @SneakyThrows
    public String addAutoComm(
            @Valid @ModelAttribute("autoCommon") AutoCommonBean autoCommonBean,
            BindingResult bindingResult,
            @RequestParam("pictureImg") MultipartFile file){
        if (bindingResult.hasErrors()) {
            return "create_car";
        }
        addAutoComm.addCommonAuto(autoCommonBean, file.getBytes());
        return "redirect:/create_car.view";
    }

}

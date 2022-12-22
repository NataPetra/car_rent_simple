package my.controller;

import my.beans.UserCommonBean;
import my.service.user_services.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUserController {

    @Autowired
    private AddUserService addUserService;

    @GetMapping("/registration.view")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration.action")
    public String addUserCommon(UserCommonBean userCommonBean){
        //System.out.println("Call addUser: " + userCommonBean);
        addUserService.addUserForm(userCommonBean);
        return "redirect:/index.html";
    }
}

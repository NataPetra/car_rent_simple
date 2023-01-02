package my.controller;

import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PersonalPageController {

    @Autowired
    private UserService userService;

    @GetMapping("/personal_page.view")
    public ModelAndView orderPage(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ModelAndView("personal_page",
                Map.of("appUser", userService.findAllByEmail(email).get(0)));
    }

}

package my.controller;

import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Secured({ "ROLE_ADMIN" })
    @GetMapping("/admin.view")
    public ModelAndView adminPage(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ModelAndView("admin_page",
                Map.of("appAdmin", userService.findAllByEmail(email).get(0)));
    }
}

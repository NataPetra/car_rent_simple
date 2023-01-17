package my.rest;

import my.beans.UserCommonBean;
import my.service.user_services.AdminUserService;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UpdateUserRestController {

    @Autowired
    public AdminUserService adminUserService;

    @GetMapping("/admin_update_user/{id}.view")
    public UserCommonBean updateUserRole(@PathVariable("{user.userId}") Integer id){
        return adminUserService.showUserById(id);
    }
}

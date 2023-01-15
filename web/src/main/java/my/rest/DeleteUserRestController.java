package my.rest;

import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin_delete_user/{user.userId}.view")
    public void deleteUser(@PathVariable("user.userId") Integer id){
        userService.deleteById(id);
    }
}

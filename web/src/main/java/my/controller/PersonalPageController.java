package my.controller;

import my.beans.UserCommonBean;
import my.service.order_services.OrderListService;
import my.service.user_services.UpdateUserService;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PersonalPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private UpdateUserService updateUserService;
    @Autowired
    private OrderListService orderListService;

    @GetMapping("/personal_page.view")
    public ModelAndView personalUserPage(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ModelAndView("personal_page",
                Map.of("appUser", userService.findAllByEmail(email).get(0)));
    }

    @GetMapping("/edit_personal_info/{user.userId}.view")
    public ModelAndView personalInfoPage(@PathVariable("user.userId") Integer id){
        return new ModelAndView("personal_info",
                Map.of("appUser", updateUserService.createUserCommonBean(id)));
    }

    @PostMapping ("/edit_personal_info/{user.userId}.action")
    public String updatePersonalInfoPage(@PathVariable("user.userId") Integer id, UserCommonBean userCommonBean){
        System.out.println("Call update Auto controller");
        updateUserService.updatePersonalInfo(userCommonBean, id);
        return "redirect:/personal_page.view";
    }

    @GetMapping("/order_list_old/{user.userId}.view")
    public ModelAndView orderListOldPage(@PathVariable("user.userId") Integer id){
        return new ModelAndView("order_list",
                Map.of("orders", orderListService.listOfOrders(id, true)));
    }

    @GetMapping("/order_list_new/{user.userId}.view")
    public ModelAndView orderListNewPage(@PathVariable("user.userId") Integer id){
        return new ModelAndView("order_list",
                Map.of("orders", orderListService.listOfOrders(id, false)));
    }

}

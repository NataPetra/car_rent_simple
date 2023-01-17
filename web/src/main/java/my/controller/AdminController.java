package my.controller;

import lombok.SneakyThrows;
import my.beans.AutoCommonBean;
import my.beans.RoleBean;
import my.beans.UserCommonBean;
import my.service.order_services.AdminOrderService;
import my.service.order_services.OrderService;
import my.service.user_services.AdminUserService;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminOrderService adminOrderService;
    @Autowired
    private OrderService orderService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin.view")
    public ModelAndView adminPage() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ModelAndView("admin_page",
                Map.of("appAdmin", userService.findAllByEmail(email).get(0)));
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_list_of_users.view")
    public ModelAndView showListOfUsers() {
        return new ModelAndView("admin_list_of_users",
                Map.of("listUsers", adminUserService.showUsers()));
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_update_user/{user.userId}.view")
    public ModelAndView showInfoUser(@PathVariable("user.userId") Integer id) {
        return new ModelAndView("admin_update_user",
                Map.of("userCommonBean", adminUserService.showUserById(id)));
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<UserCommonBean> userCommonBean = restTemplate.getForEntity(
//            "http://localhost:8080/car_rent/admin_update_user/{user.userId}.view",
//            UserCommonBean.class);
//        return new ModelAndView("admin_update_user",
//                                Map.of("userCommonBean", userCommonBean));
    }

    @PostMapping("/admin_update_user/{user.userId}.action")
    @SneakyThrows
    public String updateAutoComm(@PathVariable("user.userId") Integer id,
                                 RoleBean roleBean) {
        adminUserService.changeRole(id, roleBean);
        return "redirect:/admin_list_of_users.view";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_list_of_orders.view")
    public ModelAndView showListOfOrdersSortByDate() {
        return new ModelAndView("admin_list_of_orders",
                Map.of("listOrders", adminOrderService.getOrderFilterByDate()));
    }

    @GetMapping("/admin_list_of_orders/{pageId}.view")
    public ModelAndView listOfCarPageWithPagination(@PathVariable int pageId) {
        int total = 10;
        long countOrders = orderService.countOrders();
        List list = orderService.getAllOrderPage(pageId - 1, total);
        long amountOfPages = countOrders / total;
        if (countOrders % total != 0) {
            amountOfPages++;
        }
        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i <= amountOfPages; i++) {
            pages.add(i);
        }
        return new ModelAndView(
                "admin_list_of_orders",
                Map.of("listOrders", list,
                        "pages", pages)
        );
    }

}

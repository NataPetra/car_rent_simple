package my.controller;

import lombok.SneakyThrows;
import my.beans.AutoCommonBean;
import my.beans.AutoWithOrders;
import my.beans.RoleBean;
import my.beans.UserCommonBean;
import my.service.auto_services.AutoService;
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
    @Autowired
    private AutoService autoService;

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

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_delete_order/{order.id}.action")
    public String deleteConfirmCarPage(@PathVariable("order.id") Integer id) {
        orderService.deleteById(id);
        return "redirect:/admin_list_of_orders.view";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_list_of_car_with_orders/{pageId}.view")
    public ModelAndView showListOfCarsWithOrders(@PathVariable int pageId) {
        int total = 8;
        long countAuto = autoService.countAuto();
        System.out.println(countAuto);
        List<AutoWithOrders> list = adminOrderService.getAutoWithOrderList(pageId - 1, total);
        System.out.println(list);
        long amountOfPages = countAuto / total;
        if (countAuto % total != 0) {
            amountOfPages++;
        }
        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i <= amountOfPages; i++) {
            pages.add(i);
        }
        return new ModelAndView(
                "admin_list_of_cars_with_orders",
                Map.of("listCars", list,
                        "pages", pages)
        );
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_one_car_orders/{car.id}.view")
    public ModelAndView showListOfOrdersByCar(@PathVariable("car.id") Integer id) {
        return new ModelAndView("admin_orders_by_car",
                Map.of("listOrders", adminOrderService.getListOfOrdersByAuto(id)));
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_order/{order.id}.view")
    public ModelAndView showOrdersById(@PathVariable("order.id") Integer id) {
        return new ModelAndView("admin_order",
                Map.of("order", adminOrderService.getInfoOrderForAdmin(id)));
    }
}

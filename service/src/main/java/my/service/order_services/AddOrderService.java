package my.service.order_services;

import my.beans.AutoCommonBean;
import my.beans.OrderCommonBean;
import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import my.entity.users.User;
import my.service.auto_services.AutoService;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddOrderService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private AutoOrderService autoOrderService;
    @Autowired
    private AutoService autoService;

    public AutoCommonBean getAutoCommonBeanForOrder(Integer id){
        Auto auto = autoService.findById(id);
        AutoCommonBean autoCommonBean = new AutoCommonBean();
        autoCommonBean.setId(auto.getId());
        autoCommonBean.setColour(auto.getColour());
        autoCommonBean.setBrandName(auto.getBrand().getBrandName());
        autoCommonBean.setPrice(auto.getPrice().toString());
        autoCommonBean.setModelName(auto.getModel().getModelName());
        autoCommonBean.setReleaseYear(auto.getAutoDetails().getReleaseYear());
        return autoCommonBean;
    }

    public void addOrder(Integer id, OrderCommonBean orderCommonBean, LocalDate s, LocalDate f){
        Auto auto = autoService.findById(id);
        AutoOrder autoOrder = autoOrderService.findByModelBrandYearColour(
                auto.getModel().getModelName(),
                auto.getBrand().getBrandName(),
                auto.getAutoDetails().getReleaseYear(),
                auto.getColour());
        if(autoOrder==null){
            autoOrder = new AutoOrder();
            autoOrder.setAuto(auto);
            autoOrder = autoOrderService.addAutoOrder(autoOrder);
        }
        User user = userService.findById(1);
        UserOrder userOrder = userOrderService.findByEmail(user.getEmail());
        if(userOrder==null){
            userOrder = new UserOrder();
            userOrder.setUser(user);
            userOrder = userOrderService.addUserOrder(userOrder);
        }
        Order order = new Order();
        order.setAutoOrder(autoOrder);
        order.setUserOrder(userOrder);
        order.setComments(orderCommonBean.getComments());
        order.setAmountOfDays(orderCommonBean.getAmountOfDays());
        order.setDateStart(s);
        order.setDateFinish(f);
        orderService.addOrder(order);
    }

    public List<String> listOfDatesForMessage(Integer id){
        Auto auto = autoService.findById(id);
        AutoOrder autoOrder = autoOrderService.findByAuto(auto);
        List<Order> ordersByAuto = orderService.findByAutoOrder(autoOrder);
        List<String> dates = new ArrayList<>();
        if(ordersByAuto!=null){
            for (Order value: ordersByAuto) {
                dates.add("from " + value.getDateStart().toString() + " to " + value.getDateFinish().toString());
            }
        }
        return dates;
    }
}

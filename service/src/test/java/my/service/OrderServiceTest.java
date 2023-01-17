package my.service;

import my.beans.OrderAutoUserBean;
import my.config.RootConfig;
import my.entity.auto.Auto;
import my.entity.orders.Order;
import my.service.auto_services.AutoService;
import my.service.order_services.AdminOrderService;
import my.service.order_services.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class OrderServiceTest {

    @Autowired
    private AutoService autoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AdminOrderService adminOrderService;

    @Test
    public void getAllOrdersByAuto(){
        Auto auto = autoService.findById(2);

        List<Order> orderList = orderService.findByAuto(auto);

        for (Order or: orderList) {
            System.out.println(or);
        }

    }

    @Test
    public void deleteOrder(){
        if (orderService.existsById(11)){
            orderService.deleteById(11);
        }
        System.out.println(orderService.existsById(11));
    }

    @Test
    public void getAllInOrderByDate(){
        List<Order> inOrderDate = orderService.findInOrderDate();
        for (Order or: inOrderDate) {
            System.out.println(or);
        }
    }

    @Test
    public void getAllInOrderByDateOrderBean(){
        List<OrderAutoUserBean> orderFilterByDate = adminOrderService.getOrderFilterByDate();
        for (OrderAutoUserBean or: orderFilterByDate) {
            System.out.println(or);
        }
    }

}



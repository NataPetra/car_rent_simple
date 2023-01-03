package my.service.order_services;

import my.beans.OrderListBean;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import my.entity.users.User;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderListService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserOrderService userOrderService;

    @Transactional
    public List<OrderListBean> listOfOrders(Integer id, Boolean isPrevious){
        UserOrder userOrder = userOrderService.findUserOrderByUserId(id);
        List<Order> orders = orderService.findByUserOrder(userOrder);
        LocalDate now = LocalDate.now();
        List<OrderListBean> ordersOld = new ArrayList<>();
        List<OrderListBean> ordersNew = new ArrayList<>();
        if (orders!=null){
            for (Order value: orders) {
                if (value.getDateFinish().isBefore(now)){
                    ordersOld.add(createOrderListBean(value));
                }
                ordersNew.add(createOrderListBean(value));
            }
        }
        return isPrevious? ordersOld:ordersNew;
    }

    private OrderListBean createOrderListBean(Order value){
        OrderListBean listBean = new OrderListBean();
        listBean.setBrandName(value.getAutoOrder().getAuto().getBrand().getBrandName().toUpperCase());
        listBean.setModelName(value.getAutoOrder().getAuto().getModel().getModelName().toUpperCase());
        listBean.setReleaseYear(value.getAutoOrder().getAuto().getAutoDetails().getReleaseYear());
        listBean.setDateStart(value.getDateStart());
        listBean.setDateFinish(value.getDateFinish());
        return listBean;
    }
}

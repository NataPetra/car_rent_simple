package my.service.order_services;

import my.beans.OrderPDFBean;
import my.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderReportService {

    @Autowired
    private OrderService orderService;

    @Transactional
    public OrderPDFBean createPDFOrderFile(Integer id){
        Order order = orderService.findById(id);
        OrderPDFBean orderPDFBean = new OrderPDFBean();
        orderPDFBean.setId(id);
        orderPDFBean.setName("Order number: " + order.getOrder_id() + ".");
        orderPDFBean.setDate(LocalDateTime.now());
        orderPDFBean.setFirstName(order.getUserOrder().getUser().getUserDetails().getFirstName().toUpperCase());
        orderPDFBean.setLastName(order.getUserOrder().getUser().getUserDetails().getLastName().toUpperCase());
        orderPDFBean.setBrandName(order.getAutoOrder().getAuto().getBrand().getBrandName().toUpperCase());
        orderPDFBean.setModelName(order.getAutoOrder().getAuto().getModel().getModelName().toUpperCase());
        orderPDFBean.setReleaseYear(order.getAutoOrder().getAuto().getAutoDetails().getReleaseYear());
        orderPDFBean.setAmountOfDays(order.getAmountOfDays());
        orderPDFBean.setDateStart(order.getDateStart());
        orderPDFBean.setDateFinish(order.getDateFinish());
        orderPDFBean.setPrice(order.getAutoOrder().getAuto().getPrice().doubleValue()*order.getAmountOfDays());
        return orderPDFBean;
    }
}

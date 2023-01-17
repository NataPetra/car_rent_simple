package my.service.order_services;

import my.beans.AutoWithOrders;
import my.beans.OrderAutoUserBean;
import my.beans.OrderListBean;
import my.entity.auto.Auto;
import my.entity.orders.Order;
import my.service.auto_services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminOrderService {

    @Autowired
    private AutoService autoService;
    @Autowired
    private OrderService orderService;

    public List<AutoWithOrders> getAutoWithOrderList(){
        List<Auto> autos = autoService.allAuto();
        List<AutoWithOrders> finalList = new ArrayList<>();
        for (Auto car: autos) {
            AutoWithOrders autoWithOrders = new AutoWithOrders();
            autoWithOrders.setModel(car.getModel().getModelName().toUpperCase());
            autoWithOrders.setBrand(car.getBrand().getBrandName().toUpperCase());
            autoWithOrders.setId(car.getId());
            autoWithOrders.setColour(car.getColour());
            autoWithOrders.setYearRealize(car.getAutoDetails().getReleaseYear().toString());
            List<Order> orderList = orderService.findByAuto(car);
            if(orderList==null){
                autoWithOrders.setCountOfOrders(0);
            } else {
                autoWithOrders.setCountOfOrders(orderList.size());
            }
        }
        return finalList;
    }

    public List<OrderListBean> getListOfOrdersByAuto(Integer id){
        Auto auto = autoService.findById(id);
        List<Order> orderList = orderService.findByAuto(auto);
        List<OrderListBean> listBeans = new ArrayList<>();
        if (orderList.size()>0){
            for (Order or: orderList) {
                OrderListBean listBean = new OrderListBean();
                listBean.setModelName(or.getAutoOrder().getAuto().getModel().getModelName().toUpperCase());
                listBean.setBrandName(or.getAutoOrder().getAuto().getBrand().getBrandName().toUpperCase());
                listBean.setReleaseYear(or.getAutoOrder().getAuto().getAutoDetails().getReleaseYear());
                listBean.setId(or.getOrder_id());
                listBean.setDateStart(or.getDateStart());
                listBean.setDateFinish(or.getDateFinish());
                listBeans.add(listBean);
            }
        }
        return listBeans;
    }

    public OrderAutoUserBean getInfoOrderForAdmin(Integer id){
        Order or = orderService.findById(id);
        OrderAutoUserBean orderAutoUserBean = new OrderAutoUserBean();
        return mapperOrderAutoUserBean(or, orderAutoUserBean);
    }

    public List<OrderAutoUserBean> getOrderFilterByDate(){
        List<Order> orders = orderService.findInOrderDate();
        List<OrderAutoUserBean> orderAutoUserBeans = new ArrayList<>();
        for (Order or: orders) {
            OrderAutoUserBean orderAutoUserBean = new OrderAutoUserBean();
            orderAutoUserBeans.add(mapperOrderAutoUserBean(or, orderAutoUserBean));
        }
        return orderAutoUserBeans;
    }

    private OrderAutoUserBean mapperOrderAutoUserBean(Order or, OrderAutoUserBean orderAutoUserBean) {
        orderAutoUserBean.setId(or.getOrder_id());
        orderAutoUserBean.setModel(or.getAutoOrder().getAuto().getModel().getModelName().toUpperCase());
        orderAutoUserBean.setBrand(or.getAutoOrder().getAuto().getBrand().getBrandName().toUpperCase());
        orderAutoUserBean.setColour(or.getAutoOrder().getAuto().getColour());
        orderAutoUserBean.setYearRealize(or.getAutoOrder().getAuto().getAutoDetails().getReleaseYear());
        orderAutoUserBean.setFirstName(or.getUserOrder().getUser().getUserDetails().getFirstName().toUpperCase());
        orderAutoUserBean.setLastName(or.getUserOrder().getUser().getUserDetails().getLastName().toUpperCase());
        orderAutoUserBean.setEmail(or.getUserOrder().getUser().getEmail());
        orderAutoUserBean.setAmountOfDays(or.getAmountOfDays());
        orderAutoUserBean.setDateStart(or.getDateStart());
        orderAutoUserBean.setDateFinish(or.getDateFinish());
        return orderAutoUserBean;
    }

}

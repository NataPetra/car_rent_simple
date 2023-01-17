package my.service.order_services;

import my.dao.OrderDao;
import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order addOrder(Order order) {
        return orderDao.create(order);
    }

    public Order findById(Integer id) {
        return orderDao.get(id);
    }

    public void deleteById(Integer id) {
        orderDao.delete(id);
    }

    public Boolean existsById(Integer id) {
        return orderDao.isExistsById(id);
    }

    public List<Order> findByAutoOrder(AutoOrder autoOrder) {
        return orderDao.findByAutoOrder(autoOrder);
    }

    public List<Order> findByUserOrder(UserOrder userOrder) {
        return orderDao.findByUserOrder(userOrder);
    }

    public List<Order> findByAuto(Auto auto) {
        return orderDao.findByAuto(auto);
    }

    public List<Order> findAll(){
        return orderDao.getAll();
    }

    public List<Order> findInOrderDate(){
        return orderDao.findInOrderDate();
    }

    public long countOrders(){
        return orderDao.count();
    }

    public List<Order> getAllOrderPage(int pageNumber, int pageSize){
        return orderDao.getAllOrderPage(pageNumber, pageSize);
    }

}

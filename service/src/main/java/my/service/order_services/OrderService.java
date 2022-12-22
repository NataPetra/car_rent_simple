package my.service.order_services;

import my.dao.OrderDao;
import my.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order addOrder (Order order){
        return orderDao.create(order);
    }

    public Order findById (Integer id){
        return orderDao.get(id);
    }

    public void deleteById (Integer id){
        orderDao.delete(id);
    }

    public Boolean existsById (Integer id){
        return orderDao.isExistsById(id);
    }

}

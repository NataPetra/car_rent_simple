package my.service.order_services;

import my.dao.UserOrderDao;
import my.entity.orders.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserOrderService {

    @Autowired
    private UserOrderDao userOrderDao;

    public UserOrder addUserOrder(UserOrder order) {
        return userOrderDao.create(order);
    }

    public UserOrder findById(Integer id) {
        return userOrderDao.get(id);
    }

    public void deleteById(Integer id) {
        userOrderDao.delete(id);
    }

    public Boolean existsById(Integer id) {
        return userOrderDao.isExistsById(id);
    }

    public UserOrder findByEmail(String email) {
        return userOrderDao.findByEmail(email);
    }

    public UserOrder findUserOrderByUserId(Integer id) {
        return userOrderDao.findUserId(id);
    }
}

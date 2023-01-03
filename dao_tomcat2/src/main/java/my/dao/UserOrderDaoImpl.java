package my.dao;

import my.entity.orders.UserOrder;
import my.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserOrderDaoImpl implements UserOrderDao{

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public UserOrder create(UserOrder userOrder) {
        return userOrderRepository.save(userOrder);
    }

    @Override
    public UserOrder get(Integer id) {
        return userOrderRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return userOrderRepository.existsById(id);
    }

    @Override
    public void delete(UserOrder userOrder) {
        userOrderRepository.delete(userOrder);
    }

    @Override
    public void delete(Integer id) {
        userOrderRepository.deleteById(id);
    }

    @Override
    public List getAll() {
        return userOrderRepository.findAll();
    }

    @Override
    public long count() {
        return userOrderRepository.count();
    }

    @Override
    public UserOrder findByEmail(String email) {
        return userOrderRepository.findUserOrderByUser_Email(email);
    }

    @Override
    public UserOrder findUserId(Integer id) {
        return userOrderRepository.findUserOrderByUser_UserId(id);
    }
}

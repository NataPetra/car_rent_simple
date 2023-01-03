package my.dao;

import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import my.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order get(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return null;
    }

    @Override
    public Order edit(Order order) {
        return null;
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List getAll() {
        return orderRepository.findAll();
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public List<Order> findByAutoOrder(AutoOrder autoOrder) {
        return orderRepository.findAllByAutoOrder(autoOrder);
    }

    @Override
    public List<Order> findByUserOrder(UserOrder userOrder) {
        return orderRepository.findAllByUserOrder(userOrder);
    }
}

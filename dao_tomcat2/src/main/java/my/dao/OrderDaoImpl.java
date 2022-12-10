package my.dao;

import my.entity.orders.Order;
import my.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.save(order);
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
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}

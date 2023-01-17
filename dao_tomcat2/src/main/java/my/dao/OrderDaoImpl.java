package my.dao;

import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import my.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        return orderRepository.existsById(id);
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
    public List<Order> getAll() {
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

    @Override
    public List<Order> findByAuto(Auto auto) {
        return orderRepository.findOrdersByAutoOrder_Auto(auto);
    }

    @Override
    public List<Order> findInOrderDate() {
        return orderRepository.findOrdersInOrderByDate();
    }

    @Override
    public List<Order> getAllOrderPage(int pageNumber, int pageSize) {
        return orderRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
}

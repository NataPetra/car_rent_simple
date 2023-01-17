package my.dao;

import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Order create(Order order);

    Order get(Integer id);

    Boolean isExistsById(Integer id);

    Order edit(Order order);

    void delete(Order order);

    void delete(Integer id);

    List<Order> getAll();

    long count();

    List<Order> findByAutoOrder(AutoOrder autoOrder);

    List<Order> findByUserOrder(UserOrder userOrder);

    List<Order> findByAuto(Auto auto);

    List<Order> findInOrderDate();

    List<Order> getAllOrderPage(int pageNumber, int pageSize);

}

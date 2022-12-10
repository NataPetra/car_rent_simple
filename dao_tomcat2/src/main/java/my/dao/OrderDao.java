package my.dao;

import my.entity.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Order create(Order order);
    Order get(Integer id);
    Boolean isExistsById (Integer id);
    Order edit(Order order);
    void delete(Order order);
    void delete(Integer id);
    List getAll();
    long count();

}

package my.repository;

import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List findAllByAutoOrder(AutoOrder autoOrder);
    List findAllByUserOrder(UserOrder userOrder);
}

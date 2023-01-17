package my.repository;

import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import my.entity.orders.Order;
import my.entity.orders.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByAutoOrder(AutoOrder autoOrder);

    List<Order> findAllByUserOrder(UserOrder userOrder);

    List<Order> findOrdersByAutoOrder_Auto(Auto auto);

    @Query(value = "SELECT * FROM order_car ORDER BY dateStart", nativeQuery = true)
    List<Order> findOrdersInOrderByDate();
}

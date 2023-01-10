package my.repository;

import my.entity.orders.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

    UserOrder findUserOrderByUser_Email(String email);

    UserOrder findUserOrderByUser_UserId(Integer id);
}

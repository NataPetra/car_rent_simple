package my.dao;

import my.entity.orders.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderDao {

    UserOrder create(UserOrder userOrder);

    UserOrder get(Integer id);

    Boolean isExistsById(Integer id);

    void delete(UserOrder userOrder);

    void delete(Integer id);

    List<UserOrder> getAll();

    long count();

    UserOrder findByEmail(String email);

    UserOrder findUserId(Integer id);
}

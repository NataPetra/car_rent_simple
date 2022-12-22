package my.dao;

import my.entity.orders.AutoOrder;
import my.entity.orders.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoOrderDao {

    AutoOrder create(AutoOrder autoOrder);
    AutoOrder get(Integer id);
    Boolean isExistsById (Integer id);
    void delete(AutoOrder autoOrder);
    void delete(Integer id);
    List getAll();
    long count();
    AutoOrder findByModelBrandColourYear(String model, String brand, Integer year, String colour);
}

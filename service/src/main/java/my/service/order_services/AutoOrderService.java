package my.service.order_services;

import my.dao.AutoOrderDao;
import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutoOrderService {

    @Autowired
    private AutoOrderDao autoOrderDao;

    public AutoOrder addAutoOrder(AutoOrder order) {
        return autoOrderDao.create(order);
    }

    public AutoOrder findById(Integer id) {
        return autoOrderDao.get(id);
    }

    public void deleteById(Integer id) {
        autoOrderDao.delete(id);
    }

    public Boolean existsById(Integer id) {
        return autoOrderDao.isExistsById(id);
    }

    public AutoOrder findByModelBrandYearColour(String model, String brand, Integer year, String colour) {
        return autoOrderDao.findByModelBrandColourYear(model, brand, year, colour);
    }

    public AutoOrder findByAuto(Auto auto) {
        return autoOrderDao.findByAuto(auto);
    }
}

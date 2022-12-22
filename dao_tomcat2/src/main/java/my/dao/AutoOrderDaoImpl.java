package my.dao;

import my.entity.orders.AutoOrder;
import my.repository.AutoOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoOrderDaoImpl implements AutoOrderDao{

    @Autowired
    private AutoOrderRepository autoOrderRepository;

    @Override
    public AutoOrder create(AutoOrder autoOrder) {
        return autoOrderRepository.save(autoOrder);
    }

    @Override
    public AutoOrder get(Integer id) {
        return autoOrderRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return autoOrderRepository.existsById(id);
    }

    @Override
    public void delete(AutoOrder autoOrder) {
        autoOrderRepository.delete(autoOrder);
    }

    @Override
    public void delete(Integer id) {
        autoOrderRepository.deleteById(id);
    }

    @Override
    public List getAll() {
        return autoOrderRepository.findAll();
    }

    @Override
    public long count() {
        return autoOrderRepository.count();
    }

    @Override
    public AutoOrder findByModelBrandColourYear(String model, String brand, Integer year, String colour) {
        return autoOrderRepository.findAutoOrderByAuto_Model_ModelNameAndAuto_Brand_BrandNameAndAuto_AutoDetails_ReleaseYearAndAuto_Colour(model, brand, year, colour);
    }
}

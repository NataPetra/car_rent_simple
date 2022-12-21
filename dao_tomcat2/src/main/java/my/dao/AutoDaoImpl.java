package my.dao;

import my.entity.auto.Auto;
import my.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoDaoImpl implements AutoDao{

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public Auto createAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto getAuto(Integer id) {
        return autoRepository.findById(id).get();
    }

    public Boolean isExistsById (Integer id) {
       return autoRepository.existsById(id);
    }

    @Override
    public Auto editAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public void deleteAuto(Auto auto) {
        autoRepository.delete(auto);
    }

    @Override
    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);
    }

    @Override
    public List getAllAutoPage(int pageNumber, int pageSize) {
        return autoRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List getAllAuto() {
        return autoRepository.findAll();
    }

    @Override
    public long countAuto() {
        return autoRepository.count();
    }

    @Override
    public Auto findAutoByBrandName(String brand){
        return autoRepository.findAutoByBrand_BrandName(brand);
    }

    @Override
    public Auto findAutoByModelName(String model){
        return autoRepository.findAutoByModel_ModelName(model);
    }
}


package my.service.auto_services;

import my.dao.AutoDao;
import my.entity.auto.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoService {

    @Autowired
    private AutoDao autoDao;

    @Transactional
    //TODO: add propogation
    public Auto addAuto (Auto auto){
        return autoDao.createAuto(auto);
    }

    @Transactional
    public Boolean existsById(Integer id){
        return autoDao.isExistsById(id);
    }

    @Transactional
    public Auto findById (Integer id){
        return autoDao.getAuto(id);
    }

    @Transactional
    public void deleteById (Integer id){
        autoDao.deleteAuto(id);
    }

    @Transactional
    public List <Auto> allAuto(){
        return autoDao.getAllAuto();
    }

    @Transactional
    public List<Auto> allAuto(int pageNumber, int pageSize){
        return autoDao.getAllAutoPage(pageNumber, pageSize);
    }

    @Transactional
    public Auto findByBrand(String brand){
        return autoDao.findAutoByBrandName(brand);
    }

    @Transactional
    public Auto findByModel(String model){
        return autoDao.findAutoByModelName(model);
    }

    @Transactional
    public Auto findByModelBrandYearColour(String model, String brand, Integer year, String colour){
        return autoDao.findByModelBrandColourYear(model, brand, year, colour);
    }

    @Transactional
    public long countAuto(){
        return autoDao.countAuto();
    }

    @Transactional
    public List<Auto> findAllByModelName(String model){
        return autoDao.findAutosByModel_ModelName(model);
    }
}

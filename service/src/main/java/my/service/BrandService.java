package my.service;

import my.dao.BrandDao;
import my.entity.auto.BodyType;
import my.entity.auto.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    @Transactional
    public Brand addBrand (Brand brand){
        return brandDao.create(brand);
    }

    @Transactional
    public Brand findById (Integer id){
        return brandDao.get(id);
    }

    @Transactional
    public void deleteById (Integer id){
        brandDao.delete(id);
    }

    @Transactional
    public Brand findByName (String name){
        return brandDao.getByName(name);
    }

    @Transactional
    public Integer findByModelId (Integer id){
        List listBrands = brandDao.findByModelId(id);
        return listBrands.size();
    }

    @Transactional
    public List findAllBrands(){
        return brandDao.getAll();
    }

    @Transactional
    public Long countOfBrands (){
        return brandDao.count();
    }

}

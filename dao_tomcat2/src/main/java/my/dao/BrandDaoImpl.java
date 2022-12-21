package my.dao;

import my.entity.auto.Brand;
import my.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl implements BrandDao{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand get(Integer id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand getByName(String name) {
        return brandRepository.findBrandByBrandName(name);
    }

    @Override
    public List findByModelId(Integer id){
        return brandRepository.findBrandsByModel_Id(id);
    }

    @Override
    public List getAll() {
        return brandRepository.findAll();
    }

    @Override
    public long count() {
        return brandRepository.count();
    }


}

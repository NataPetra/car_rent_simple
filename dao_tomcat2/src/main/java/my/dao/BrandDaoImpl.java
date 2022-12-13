package my.dao;

import my.entity.auto.Brand;
import my.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

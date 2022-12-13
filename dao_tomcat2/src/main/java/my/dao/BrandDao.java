package my.dao;

import my.entity.auto.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao {

    Brand create(Brand brand);
    Brand get(Integer id);
    void delete(Integer id);
    Brand getByName(String name);
}

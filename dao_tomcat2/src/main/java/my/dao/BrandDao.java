package my.dao;

import my.entity.auto.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao {

    Brand create(Brand brand);
    Brand get(Integer id);
    void delete(Integer id);
    Brand getByName(String name);
    List findByModelId(Integer id);
    List getAll();
    long count();
}

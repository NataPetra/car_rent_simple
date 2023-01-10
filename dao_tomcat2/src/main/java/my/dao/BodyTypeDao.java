package my.dao;

import my.entity.auto.BodyType;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyTypeDao {

    BodyType create(BodyType bodyType);

    BodyType get(Integer id);

    void delete(Integer id);

    BodyType getByName(String name);
}

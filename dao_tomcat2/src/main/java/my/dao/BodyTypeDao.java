package my.dao;

import my.entity.auto.BodyType;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyTypeDao {

    void create(BodyType bodyType);
    BodyType get(Integer id);
    void delete(Integer id);
}

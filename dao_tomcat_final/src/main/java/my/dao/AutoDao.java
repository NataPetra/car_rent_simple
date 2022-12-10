package my.dao;

import my.entity.auto.Auto;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoDao {

    void createAuto(Auto auto);
    Auto getAuto(Integer id);
}

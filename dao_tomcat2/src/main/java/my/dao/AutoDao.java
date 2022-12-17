package my.dao;

import my.entity.auto.Auto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoDao {

    Auto createAuto(Auto auto);
    Auto getAuto(Integer id);
    Boolean isExistsById (Integer id);
    Auto editAuto(Auto auto);
    void deleteAuto(Auto auto);
    void deleteAuto(Integer id);
    List getAllAutoPage(int pageNumber, int pageSize);
    List getAllAuto();
    long countAuto();
}

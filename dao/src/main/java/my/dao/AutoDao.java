package my.dao;

import my.entity.auto.Auto;

import java.util.List;

public interface AutoDao {

    Auto createAuto(Auto auto);
    Auto getAuto(Integer id);
    Auto editAuto(Auto auto);
    void deleteAuto(Auto auto);
    void deleteAuto(Integer id);
    List getAllAuto(int pageNumber, int pageSize);
    List getAllAuto();
    long countAuto();
}

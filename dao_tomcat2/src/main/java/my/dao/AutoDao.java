package my.dao;

import my.entity.auto.Auto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoDao {

    Auto createAuto(Auto auto);

    Auto getAuto(Integer id);

    Boolean isExistsById(Integer id);

    void deleteAuto(Auto auto);

    void deleteAuto(Integer id);

    List<Auto> getAllAutoPage(int pageNumber, int pageSize);

    List<Auto> getAllAuto();

    long countAuto();

    Auto findAutoByBrandName(String brand);

    Auto findAutoByModelName(String model);

    Auto findByModelBrandColourYear(String model, String brand, Integer year, String colour);

    List<Auto> findAutosByModel_ModelName(String model);
}

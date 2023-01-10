package my.dao;

import my.entity.auto.AutoDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoDetailsDao {

    AutoDetails createAutoDetails(AutoDetails auto);

    AutoDetails getAutoDetails(Integer id);

    Boolean isExistsById(Integer id);

    void deleteAutoDetails(AutoDetails auto);

    void deleteAutoDetails(Integer id);

    long countAutoDetails();

    AutoDetails findByBodyType(String type);
}

package my.dao;

import my.entity.auto.AutoDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoDetailsDao {

    AutoDetails createAutoDetails(AutoDetails auto);
    AutoDetails getAutoDetails(Integer id);
    Boolean isExistsById (Integer id);
    AutoDetails editAutoDetails(AutoDetails auto);
    void deleteAutoDetails(AutoDetails auto);
    void deleteAutoDetails(Integer id);
    List getAllAutoDetails(int pageNumber, int pageSize);
    List getAllAutoDetails();
    long countAutoDetails();
    AutoDetails findByBodyType(String type);
}

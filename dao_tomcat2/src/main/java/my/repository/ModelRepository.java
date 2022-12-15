package my.repository;

import my.entity.auto.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query(value = "SELECT * FROM model m WHERE m.model_name=:name", nativeQuery = true)
    Model findByName(@Param("name") String name);

    @Query(value = "SELECT model_name FROM model m WHERE m.model_id=:id", nativeQuery = true)
    String findModelNameById(@Param("id") Integer id);

}

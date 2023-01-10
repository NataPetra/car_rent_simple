package my.repository;

import my.entity.auto.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Brand findBrandByBrandName(String name);

    @Query(value = "SELECT brand_name FROM brand b WHERE m.brand_id=:id", nativeQuery = true)
    String findBrandNameById(@Param("id") Integer id);

    List<Brand> findBrandsByModel_Id(Integer id);
}

package my.repository;

import my.entity.auto.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    Auto findAutoByBrand_BrandName(String brand);
    Auto findAutoByModel_ModelName(String model);
    Auto findAutoByModel_ModelNameAndBrand_BrandNameAndAutoDetails_ReleaseYearAndColour(
            String model,
            String brand,
            Integer year,
            String colour);

}

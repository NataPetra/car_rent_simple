package my.repository;

import my.entity.auto.Auto;
import my.entity.orders.AutoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoOrderRepository extends JpaRepository<AutoOrder, Integer> {

    AutoOrder findAutoOrderByAuto_Model_ModelNameAndAuto_Brand_BrandNameAndAuto_AutoDetails_ReleaseYearAndAuto_Colour(
            String model,
            String brand,
            Integer year,
            String colour);
}

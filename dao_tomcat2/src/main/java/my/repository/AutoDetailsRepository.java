package my.repository;

import my.entity.auto.AutoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoDetailsRepository extends JpaRepository<AutoDetails, Integer> {

    AutoDetails findAutoDetailsByBodyType_Type(String type);
}

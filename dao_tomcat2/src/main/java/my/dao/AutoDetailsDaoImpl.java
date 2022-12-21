package my.dao;

import my.entity.auto.AutoDetails;
import my.repository.AutoDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoDetailsDaoImpl implements AutoDetailsDao{

    @Autowired
    private AutoDetailsRepository autoDetailsRepository;

    @Override
    public AutoDetails createAutoDetails(AutoDetails auto) {
        return autoDetailsRepository.save(auto);
    }

    @Override
    public AutoDetails getAutoDetails(Integer id) {
        return autoDetailsRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return autoDetailsRepository.existsById(id);
    }

    @Override
    public void deleteAutoDetails(AutoDetails auto) {
        autoDetailsRepository.delete(auto);
    }

    @Override
    public void deleteAutoDetails(Integer id) {
        autoDetailsRepository.deleteById(id);
    }

    @Override
    public long countAutoDetails() {
        return autoDetailsRepository.count();
    }

    @Override
    public AutoDetails findByBodyType(String type){
        return autoDetailsRepository.findAutoDetailsByBodyType_Type(type);
    }
}

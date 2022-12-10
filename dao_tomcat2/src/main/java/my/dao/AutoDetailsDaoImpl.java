package my.dao;

import my.entity.auto.AutoDetails;
import my.repository.AutoDetailsRepository;
import my.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoDetailsDaoImpl implements AutoDetailsDao{

    @Autowired
    private AutoDetailsRepository autoDetailsRepository;

    @Override
    public void createAutoDetails(AutoDetails auto) {
        autoDetailsRepository.save(auto);
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
    public AutoDetails editAutoDetails(AutoDetails auto) {
        return null;
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
    public List getAllAutoDetails(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List getAllAutoDetails() {
        return null;
    }

    @Override
    public long countAutoDetails() {
        return autoDetailsRepository.count();
    }
}

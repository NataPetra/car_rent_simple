package my.service;

import my.dao.AutoDetailsDao;
import my.entity.auto.AutoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoDetailsService {

    @Autowired
    private AutoDetailsDao autoDetailsDao;

    @Transactional
    public AutoDetails addAutoDetails (AutoDetails auto){
        return autoDetailsDao.createAutoDetails(auto);
    }

    @Transactional
    public Boolean existsById(Integer id){
        return autoDetailsDao.isExistsById(id);
    }

    @Transactional
    public AutoDetails findById (Integer id){
        return autoDetailsDao.getAutoDetails(id);
    }

    @Transactional
    public void deleteById (Integer id){
        autoDetailsDao.deleteAutoDetails(id);
    }
}

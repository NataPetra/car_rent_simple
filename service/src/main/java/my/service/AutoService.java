package my.service;

import my.dao.AutoDao;
import my.entity.auto.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutoService {

    @Autowired
    private AutoDao autoDao;

    public void addAuto (Auto auto){
        autoDao.createAuto(auto);
    }

    public Boolean existsById(Integer id){
        return autoDao.isExistsById(id);
    }

    public Auto findById (Integer id){
        return autoDao.getAuto(id);
    }

}

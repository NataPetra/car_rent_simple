package my.service;

import my.dao.AutoDao;
import my.entity.auto.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoService {

    @Autowired
    private AutoDao autoDao;

    @Transactional
    public Auto addAuto (Auto auto){
        return autoDao.createAuto(auto);
    }

    public Boolean existsById(Integer id){
        return autoDao.isExistsById(id);
    }

    @Transactional
    public Auto findById (Integer id){
        return autoDao.getAuto(id);
    }

    @Transactional
    public void deleteById (Integer id){
        autoDao.deleteAuto(id);
    }

    @Transactional
    public List allAuto(){
        return autoDao.getAllAuto();
    }

}

package my.service;

import my.dao.ModelDao;
import my.entity.auto.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModelService {

    @Autowired
    private ModelDao modelDao;

    @Transactional
    public void addModel (Model model){
        modelDao.createModel(model);
    }

    @Transactional
    public Model findById (Integer id){
        return modelDao.getModel(id);
    }

    @Transactional
    public void deleteById (Integer id){
        modelDao.deleteModel(id);
    }


}

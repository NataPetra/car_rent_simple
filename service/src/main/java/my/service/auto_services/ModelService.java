package my.service.auto_services;

import my.dao.ModelDao;
import my.entity.auto.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelDao modelDao;

    @Transactional
    public Model addModel (Model model){
        return modelDao.createModel(model);
    }

    @Transactional
    public Model findById (Integer id){
        return modelDao.getModelId(id);
    }

    @Transactional
    public void deleteById (Integer id){
        modelDao.deleteModel(id);
    }

    @Transactional
    public Model findByName (String name){
        return modelDao.getByName(name);
    }

    @Transactional
    public List findAllModels(){
        return modelDao.getAll();
    }

    @Transactional
    public Long countOfModels (){
        return modelDao.count();
    }

    @Transactional
    public List<String> findAllNames(){
        return modelDao.findAllModelNames();
    }

}

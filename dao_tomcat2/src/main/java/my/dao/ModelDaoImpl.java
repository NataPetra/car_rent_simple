package my.dao;

import my.entity.auto.Model;
import my.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDaoImpl implements ModelDao{

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public void createModel(Model model) {
        modelRepository.save(model);
    }

    @Override
    public Model getModel(Integer id) {
        return modelRepository.findById(id).orElseGet(null);
    }

    @Override
    public void deleteModel(Integer id) {
        modelRepository.deleteById(id);
    }


}

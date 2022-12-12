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
    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model getByName(String name) {
        return modelRepository.findByName(name);
    }

    @Override
    public Model getModelId(Integer id) {
        return modelRepository.findById(id).get();
    }

    @Override
    public void deleteModel(Integer id) {
        modelRepository.deleteById(id);
    }


}
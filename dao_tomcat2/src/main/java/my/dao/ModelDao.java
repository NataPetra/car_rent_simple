package my.dao;

import my.entity.auto.Model;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelDao {

    Model createModel(Model model);
    Model getByName(String name);
    Model getModelId(Integer id);
    void deleteModel(Integer id);
}
package my.dao;

import my.entity.auto.Model;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelDao {

    void createModel(Model model);
    Model getModel(Integer id);
    void deleteModel(Integer id);
}

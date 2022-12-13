package my.dao;

import my.entity.auto.BodyType;
import my.repository.BodyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BodyTypeDaoImpl implements BodyTypeDao{

    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    @Override
    public BodyType create(BodyType bodyType) {
        return bodyTypeRepository.save(bodyType);
    }

    @Override
    public BodyType get(Integer id) {
        return bodyTypeRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        bodyTypeRepository.deleteById(id);
    }

    @Override
    public BodyType getByName(String type) {
        return bodyTypeRepository.findBodyTypeByType(type);
    }
}

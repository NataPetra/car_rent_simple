package my.service.auto_services;

import my.dao.BodyTypeDao;
import my.entity.auto.BodyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BodyTypeService {

    @Autowired
    private BodyTypeDao bodyTypeDao;

    @Transactional
    public BodyType addBodyType(BodyType bodyType) {
        return bodyTypeDao.create(bodyType);
    }

    @Transactional
    public BodyType findById(Integer id) {
        return bodyTypeDao.get(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        bodyTypeDao.delete(id);
    }

    @Transactional
    public BodyType findByName(String name) {
        return bodyTypeDao.getByName(name);
    }

}

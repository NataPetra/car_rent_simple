package my.service.auto_services;

import my.dao.AutoPictureDao;
import my.entity.auto.AutoDetails;
import my.entity.auto.AutoPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoPictureService {

    @Autowired
    private AutoPictureDao autoPictureDao;

    @Transactional
    public AutoPicture addAutoPicture (AutoPicture auto){
        return autoPictureDao.create(auto);
    }

    @Transactional
    public AutoPicture findById (Integer id){
        return autoPictureDao.get(id);
    }

    @Transactional
    public void deleteById (Integer id){
        autoPictureDao.delete(id);
    }
}

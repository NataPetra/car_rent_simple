package my.dao;

import my.entity.auto.AutoPicture;
import my.repository.AutoPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoPictureDaoImpl implements AutoPictureDao{

    @Autowired
    private AutoPictureRepository autoPictureRepository;

    @Override
    public AutoPicture create(AutoPicture autoPicture) {
        return autoPictureRepository.save(autoPicture);
    }

    @Override
    public AutoPicture get(Integer id) {
        return autoPictureRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        autoPictureRepository.deleteById(id);
    }
}

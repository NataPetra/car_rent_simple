package my.dao;

import my.entity.auto.AutoPicture;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoPictureDao {

    AutoPicture create(AutoPicture autoPicture);
    AutoPicture get(Integer id);
    void delete(Integer id);
}

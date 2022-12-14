package my.service.auto_services;

import my.beans.AutoDetailsBean;
import my.dao.AutoDao;
import my.dao.AutoDetailsDao;
import my.entity.auto.Auto;
import my.entity.auto.AutoDetails;
import my.entity.auto.AutoPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoDetailsService {

    @Autowired
    private AutoDetailsDao autoDetailsDao;
    @Autowired
    private AutoDao autoDao;
    @Autowired
    private AutoPictureService autoPictureService;


    @Transactional
    public AutoDetails addAutoDetails(AutoDetails auto) {
        return autoDetailsDao.createAutoDetails(auto);
    }

    @Transactional
    public Boolean existsById(Integer id) {
        return autoDetailsDao.isExistsById(id);
    }

    @Transactional
    public AutoDetails findById(Integer id) {
        return autoDetailsDao.getAutoDetails(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        autoDetailsDao.deleteAutoDetails(id);
    }

    @Transactional
    public AutoDetailsBean showAllInfAutoById(Integer id) {
        Auto auto = autoDao.getAuto(id);
        AutoDetails autoDetails = autoDetailsDao.getAutoDetails(id);

        AutoDetailsBean autoDetailsBean = new AutoDetailsBean();
        autoDetailsBean.setId(auto.getId());
        autoDetailsBean.setModelName(auto.getModel().getModelName().toUpperCase());
        autoDetailsBean.setBrandName(auto.getBrand().getBrandName().toUpperCase());
        autoDetailsBean.setBodyType(autoDetails.getBodyType().getType());
        if (autoDetails.getAutomaticTransmission()) {
            autoDetailsBean.setAutomaticTransmission("");
        } else {
            autoDetailsBean.setAutomaticTransmission("no");
        }
        if (autoDetails.getWithDriver()) {
            autoDetailsBean.setDriver("with");
        } else {
            autoDetailsBean.setDriver("without");
        }
        autoDetailsBean.setColour(auto.getColour());
        autoDetailsBean.setPrice(auto.getPrice().toString());
        autoDetailsBean.setReleaseYear(autoDetails.getReleaseYear());
        if (auto.getAutoPicture() != null) {
            AutoPicture autoPicture = autoPictureService.findById(id);
            autoDetailsBean.setPicture(autoPicture.getPicture());
        }
        return autoDetailsBean;
    }

    public AutoDetails findByType(String type) {
        return autoDetailsDao.findByBodyType(type);
    }
}

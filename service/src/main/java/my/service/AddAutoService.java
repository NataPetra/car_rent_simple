package my.service;

import my.beans.AutoCommonBean;
import my.dao.AutoDao;
import my.dao.AutoDetailsDao;
import my.dao.ModelDao;
import my.entity.auto.Auto;
import my.entity.auto.AutoDetails;
import my.entity.auto.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddAutoService {

    @Autowired
    private AutoDao autoDao;
    @Autowired
    private AutoDetailsDao autoDetailsDao;
    @Autowired
    private ModelDao modelDao;

    public void addCommonAuto (AutoCommonBean autoCommonBean){
        Auto auto = new Auto();
        Model model = new Model();
        AutoDetails autoDetails = new AutoDetails();

        model.setModelName(autoCommonBean.getModelName());
        modelDao.createModel(model);

        auto.setPrice(new BigDecimal(autoCommonBean.getPrice()));
        auto.setColour(autoCommonBean.getColour());
        auto.setModel(modelDao.getModel(1));
        autoDao.createAuto(auto);

        autoDetails.setAuto(autoDao.getAuto(1));
        //посмотреть дефолт Bolean
        if(autoCommonBean.getAutomaticTransmission().equalsIgnoreCase("yes")){
            autoDetails.setAutomaticTransmission(true);
        } else {
            autoDetails.setAutomaticTransmission(false);
        }
        autoDetails.setReleaseYear(autoCommonBean.getReleaseYear());
        if(autoCommonBean.getAutomaticTransmission().equalsIgnoreCase("yes")){
            autoDetails.setWithDriver(true);
        } else {
            autoDetails.setWithDriver(false);
        }
        autoDetailsDao.createAutoDetails(autoDetails);

    }

}

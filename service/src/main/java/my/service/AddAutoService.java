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

    //добавить логгер

    @Autowired
    private AutoDao autoDao;
    @Autowired
    private AutoDetailsDao autoDetailsDao;
    @Autowired
    private ModelDao modelDao;

    public void addCommonAuto (AutoCommonBean autoCommonBean){
        //вывести бин
        Auto auto = new Auto();
        Model model = modelDao.getByName(autoCommonBean.getModelName());
        AutoDetails autoDetails = new AutoDetails();

        if (model!=null){
            auto.setModel(model);
        } else {
            model = new Model();
            model.setModelName(autoCommonBean.getModelName());
            Model modelDB = modelDao.createModel(model);
            auto.setModel(modelDB);
        }

        //вывести по всем объектам перед соданием в базе

        auto.setPrice(new BigDecimal(autoCommonBean.getPrice()));
        auto.setColour(autoCommonBean.getColour());

        //вывести по всем объектам перед соданием в базе
        Auto autoDB = autoDao.createAuto(auto);

        autoDetails.setAuto(autoDB);
        //посмотреть дефолт Bolean
        if("yes".equalsIgnoreCase(autoCommonBean.getAutomaticTransmission())){
            autoDetails.setAutomaticTransmission(true);
        } else {
            autoDetails.setAutomaticTransmission(false);
        }
        autoDetails.setReleaseYear(autoCommonBean.getReleaseYear());
        if("yes".equalsIgnoreCase(autoCommonBean.getAutomaticTransmission())){
            autoDetails.setWithDriver(true);
        } else {
            autoDetails.setWithDriver(false);
        }
        //вывести по всем объектам перед соданием в базе
        autoDetailsDao.createAutoDetails(autoDetails);

        //вывести по всем объектам перед соданием в базе

    }

}

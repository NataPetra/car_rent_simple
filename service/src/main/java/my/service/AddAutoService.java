package my.service;

import my.beans.AutoCommonBean;
import my.dao.*;
import my.entity.auto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddAutoService {

    private static final Logger log = LoggerFactory.getLogger(AddAutoService.class);

    @Autowired
    private AutoService autoService;
    @Autowired
    private AutoDetailsService autoDetailsService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private BrandService brandService;

    public void addCommonAuto (AutoCommonBean autoCommonBean){
        log.info("AutoCommonBean " + autoCommonBean);

        Auto auto = new Auto();
        Model model = modelService.findByName(autoCommonBean.getModelName().toLowerCase());
        AutoDetails autoDetails = new AutoDetails();
        BodyType bodyType = bodyTypeService.findByName(autoCommonBean.getBodyType().toLowerCase());
        Brand brand = brandService.findByName(autoCommonBean.getBrandName().toLowerCase());

        if (model == null) {
            model = new Model();
            model.setModelName(autoCommonBean.getModelName());
            log.info("modelDB " + model);
            model = modelService.addModel(model);
        }

        if (bodyType==null){
            bodyType = new BodyType();
            bodyType.setType(autoCommonBean.getBodyType());
            log.info("bodyTypeDB " + bodyType);
            bodyType = bodyTypeService.addBodyType(bodyType);
        }

        if (brand==null){
            brand = new Brand();
            brand.setBrandName(autoCommonBean.getBrandName());
            brand.setModel(model);
            log.info("brandDB " + brand);
            brand = brandService.addBrand(brand);
        }

        auto.setModel(model);
        auto.setPrice(new BigDecimal(autoCommonBean.getPrice()));
        auto.setColour(autoCommonBean.getColour());
        log.info("autoDB " + auto);
        Auto autoDB = autoService.addAuto(auto);

        autoDetails.setAuto(autoDB);
        autoDetails.setAutomaticTransmission("yes".equalsIgnoreCase(autoCommonBean.getAutomaticTransmission()));
        autoDetails.setReleaseYear(autoCommonBean.getReleaseYear());
        autoDetails.setWithDriver("yes".equalsIgnoreCase(autoCommonBean.getWithDriver()));
        autoDetails.setBodyType(bodyType);
        log.info("autoDetailsDB " + auto);
        autoDetailsService.addAutoDetails(autoDetails);

    }

}

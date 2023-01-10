package my.service.auto_services;

import my.beans.AutoCommonBean;
import my.entity.auto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AutoPictureService autoPictureService;

    @Transactional
    public void addCommonAuto(
            AutoCommonBean autoCommonBean,
            byte[] picture
    ) {
        log.info("AutoCommonBean " + autoCommonBean);

        Auto auto = new Auto();
        Model model = modelService.findByName(autoCommonBean.getModelName().toLowerCase());
        AutoDetails autoDetails = new AutoDetails();
        BodyType bodyType = bodyTypeService.findByName(autoCommonBean.getBodyType().toLowerCase());
        Brand brand = brandService.findByName(autoCommonBean.getBrandName().toLowerCase());

        if (model == null) {
            model = new Model();
            model.setModelName(autoCommonBean.getModelName().toLowerCase().trim());
            log.info("modelDB " + model);
            model = modelService.addModel(model);
        }

        if (bodyType == null) {
            bodyType = new BodyType();
            bodyType.setType(autoCommonBean.getBodyType().toLowerCase().trim());
            log.info("bodyTypeDB " + bodyType);
            bodyType = bodyTypeService.addBodyType(bodyType);
        }

        if (brand == null) {
            brand = new Brand();
            brand.setBrandName(autoCommonBean.getBrandName().toLowerCase().trim());
            brand.setModel(model);
            log.info("brandDB " + brand);
            brand = brandService.addBrand(brand);
        }

        auto.setModel(model);
        auto.setBrand(brand);
        auto.setPrice(new BigDecimal(autoCommonBean.getPrice()));
        auto.setColour(autoCommonBean.getColour().toLowerCase().trim());
        log.info("autoDB " + auto);
        Auto autoDB = autoService.addAuto(auto);

        autoDetails.setAuto(autoDB);
        autoDetails.setAutomaticTransmission("yes".equalsIgnoreCase(autoCommonBean.getAutomaticTransmission()));
        autoDetails.setReleaseYear(autoCommonBean.getReleaseYear());
        autoDetails.setWithDriver("yes".equalsIgnoreCase(autoCommonBean.getWithDriver()));
        autoDetails.setBodyType(bodyType);
        log.info("autoDetailsDB " + autoDetails);
        autoDetailsService.addAutoDetails(autoDetails);

        if (auto.getAutoPicture() == null) {
            AutoPicture autoPicture = new AutoPicture();
            autoPicture.setAuto(autoDB);
            autoPicture.setPicture(picture);
            autoPictureService.addAutoPicture(autoPicture);
        }
    }
}

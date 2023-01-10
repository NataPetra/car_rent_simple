package my.service.auto_services;

import my.beans.AutoCommonBean;
import my.entity.auto.*;
import my.service.CustomMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class UpdateAutoService {

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

    public AutoCommonBean getAutoCommonBeanById(Integer id) {
        Auto auto = autoService.findById(id);
        AutoCommonBean autoCommonBean = new AutoCommonBean();
        autoCommonBean.setId(auto.getId());
        autoCommonBean.setColour(auto.getColour());
        autoCommonBean.setAutomaticTransmission(auto.getAutoDetails().getAutomaticTransmission().toString());
        autoCommonBean.setBodyType(auto.getAutoDetails().getBodyType().getType());
        autoCommonBean.setBrandName(auto.getBrand().getBrandName());
        autoCommonBean.setPrice(auto.getPrice().toString());
        autoCommonBean.setModelName(auto.getModel().getModelName());
        autoCommonBean.setReleaseYear(auto.getAutoDetails().getReleaseYear());
        autoCommonBean.setWithDriver(auto.getAutoDetails().getWithDriver().toString());
        if (auto.getAutoPicture() != null) {
            AutoPicture autoPicture = autoPictureService.findById(id);
            autoCommonBean.setPictureImg(new CustomMultipartFile(autoPicture.getPicture(), "pictureImd"));
        }
        return autoCommonBean;
    }

    public void updateAutoCommon(AutoCommonBean autoCommonBean, Integer id) {
        Auto auto = autoService.findById(id);
        AutoDetails autoDetails = autoDetailsService.findById(id);
        Model model = modelService.findByName(autoCommonBean.getModelName().toLowerCase());
        if (!auto.getModel().getModelName().equalsIgnoreCase(autoCommonBean.getModelName())) {
            if (model == null) {
                model = new Model();
                model.setModelName(autoCommonBean.getModelName().toLowerCase());
                model = modelService.addModel(model);
            }
            auto.setModel(model);
        }
        if (!auto.getBrand().getBrandName().equalsIgnoreCase(autoCommonBean.getBrandName())) {
            Brand brand = brandService.findByName(autoCommonBean.getBrandName().toLowerCase());
            if (brand == null) {
                brand = new Brand();
                brand.setBrandName(autoCommonBean.getBrandName().toLowerCase());
                brand.setModel(model);
                brand = brandService.addBrand(brand);
            }
            auto.setBrand(brand);
        }
        if (!auto.getColour().equalsIgnoreCase(autoCommonBean.getColour())) {
            auto.setColour(autoCommonBean.getColour());
        }
        if (!autoDetails.getBodyType().getType().equalsIgnoreCase(autoCommonBean.getBodyType())) {
            BodyType bodyType = bodyTypeService.findByName(autoCommonBean.getBodyType().toLowerCase());
            if (bodyType == null) {
                bodyType = new BodyType();
                bodyType.setType(autoCommonBean.getBodyType().toLowerCase());
                bodyType = bodyTypeService.addBodyType(bodyType);
            }
            autoDetails.setBodyType(bodyType);
        }
        if (!auto.getPrice().toString().equals(autoCommonBean.getPrice())) {
            auto.setPrice(new BigDecimal(autoCommonBean.getPrice()));
        }
        if (!autoDetails.getReleaseYear().equals(autoCommonBean.getReleaseYear())) {
            autoDetails.setReleaseYear(autoCommonBean.getReleaseYear());
        }
        if (autoCommonBean.getAutomaticTransmission().equalsIgnoreCase("true") || autoCommonBean.getAutomaticTransmission().equalsIgnoreCase("false")) {
            if (!autoDetails.getAutomaticTransmission().equals(Boolean.parseBoolean(autoCommonBean.getAutomaticTransmission()))) {
                autoDetails.setAutomaticTransmission(Boolean.parseBoolean(autoCommonBean.getAutomaticTransmission()));
            }
        }
        if (autoCommonBean.getWithDriver().equalsIgnoreCase("true") || autoCommonBean.getWithDriver().equalsIgnoreCase("false")) {
            if (!autoDetails.getWithDriver().equals(Boolean.parseBoolean(autoCommonBean.getWithDriver()))) {
                autoDetails.setWithDriver((Boolean.parseBoolean(autoCommonBean.getWithDriver())));
            }
        }
        autoService.addAuto(auto);
        autoDetailsService.addAutoDetails(autoDetails);
    }

    public void updateAutoCommonWithPicture(byte[] picture, Integer id) {
        Auto auto = autoService.findById(id);
        if (auto.getAutoPicture() == null) {
            AutoPicture autoPicture = new AutoPicture();
            autoPicture.setAuto(auto);
            autoPicture.setPicture(picture);
            autoPictureService.addAutoPicture(autoPicture);
        } else {
            AutoPicture autoPicture = autoPictureService.findById(id);
            autoPicture.setAuto(auto);
            autoPicture.setPicture(picture);
            autoPictureService.addAutoPicture(autoPicture);
        }

    }


}

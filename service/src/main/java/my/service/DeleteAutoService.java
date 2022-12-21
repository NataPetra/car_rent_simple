package my.service;

import my.beans.AutoCommonBean;
import my.entity.auto.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteAutoService {

    @Autowired
    private AutoService autoService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;

    @Transactional
    public AutoCommonBean saveInf(Integer id){
        Auto auto = autoService.findById(id);
        AutoCommonBean autoCommonBean = new AutoCommonBean();
        autoCommonBean.setModelName(auto.getModel().getModelName());
        autoCommonBean.setBrandName(auto.getBrand().getBrandName());
        autoCommonBean.setColour(auto.getColour());
        autoCommonBean.setReleaseYear(auto.getAutoDetails().getReleaseYear());
        return autoCommonBean;
    }

    public void deleteAllInf(Integer id){
        Auto auto = autoService.findById(id);
        Integer idModel = auto.getModel().getId();
        String brandName = auto.getBrand().getBrandName();
        Integer idBrand = auto.getBrand().getId();
        autoService.deleteById(id);
        if(autoService.findByBrand(brandName)==null){
            brandService.deleteById(idBrand);
            Integer countBrands = brandService.findByModelId(idModel);
            if(countBrands==0){
                modelService.deleteById(idModel);
            }
        }
    }

}

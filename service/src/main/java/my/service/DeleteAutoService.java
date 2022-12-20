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
    private AutoDetailsService autoDetailsService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private BrandService brandService;

    @Transactional
    public AutoCommonBean saveInf(Integer id){
        Auto auto = autoService.findById(id);
        AutoCommonBean autoCommonBean = new AutoCommonBean();
        autoCommonBean.setModelName(auto.getModel().getModelName());
        autoCommonBean.setBrandName(auto.getBrand().getBrandName());
        return autoCommonBean;
    }

    public void deleteAllInf(Integer id){
        Auto auto = autoService.findById(id);
        String modelName = auto.getModel().getModelName();
        Integer idModel = auto.getModel().getId();
        String brandName = auto.getBrand().getBrandName();
        Integer idBrand = auto.getBrand().getId();
        String type = auto.getAutoDetails().getBodyType().getType();
        Integer idBody = auto.getAutoDetails().getBodyType().getId();
        autoService.deleteById(id);
        if(autoService.findByBrand(brandName)==null){
            brandService.deleteById(idBrand);
        }
        if(autoService.findByModel(modelName)==null){
            modelService.deleteById(idModel);
        }
        if(autoDetailsService.findByType(type)==null){
            bodyTypeService.deleteById(idBody);
        }
    }

}

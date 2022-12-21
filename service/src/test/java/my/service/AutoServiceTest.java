package my.service;

import my.config.RootConfig;
import my.entity.auto.Auto;
import my.entity.auto.AutoDetails;
import my.entity.auto.Brand;
import my.entity.auto.Model;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AutoServiceTest {

    @Autowired
    private AutoService autoService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;

    private Auto auto;
    private Model bmv;
    private Brand x5;

    @Before
    public void init() {
        bmv = new Model();
        bmv.setModelName("bmw");
        Model addModel = modelService.addModel(bmv);
        x5 = new Brand();
        x5.setModel(addModel);
        x5.setBrandName("x5");
        Brand addBrand = brandService.addBrand(x5);

        auto = new Auto();
        auto.setBrand(addBrand);
        auto.setModel(addModel);
        auto.setColour("red");
        auto = autoService.addAuto(auto);
    }

    @Test
    public void crudRepositoryTest() {
        Integer autoId = auto.getId();
        System.out.println(autoService.existsById(autoId));
        Auto autoDB = autoService.findById(autoId);
        System.out.println(autoDB);

        Model modelDB = modelService.findById(autoDB.getModel().getId());
        System.out.println(modelDB);

        Brand brandDB = brandService.findById(autoDB.getBrand().getId());
        System.out.println(brandDB);

        autoDB.setPrice(new BigDecimal(10000));
        autoService.addAuto(autoDB);
        System.out.println(autoDB);

        autoService.deleteById(autoId);
        brandService.deleteById(brandDB.getId());
        modelService.deleteById(modelDB.getId());
    }

}


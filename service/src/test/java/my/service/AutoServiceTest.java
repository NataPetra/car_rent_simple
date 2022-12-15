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
    private AutoDetailsService autoDetailsService;
    @Autowired
    private BrandService brandService;

    private Auto auto;
    private Model bmv;
    private Brand x5;

//    @Before
//    public void init() {
//        bmv = new Model(null, "bmv");
//        x5 = new Brand(null, bmv, "X5");
//
//        auto = autoService.addAuto(new Auto());
//        modelService.addModel(bmv);
//        brandService.addBrand(x5);
//    }

    @Test
    @Ignore
    public void crudRepositoryTest() {
        Integer autoId = auto.getId();
        System.out.println(autoService.existsById(autoId));
        Auto autoDB = autoService.findById(autoId);

        Model modelDB = modelService.findById(bmv.getId());

        auto.setModel(modelDB);
        auto.setColour("red");
        auto.setPrice(new BigDecimal(10000));
        autoService.addAuto(auto);
        System.out.println(auto);

        autoService.deleteById(autoId);
        modelService.deleteById(autoId);
        //autoDetailsService.deleteById(1);
    }

}


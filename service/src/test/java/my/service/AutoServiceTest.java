package my.service;

import my.config.RootConfig;
import my.entity.auto.Auto;
import my.entity.auto.AutoDetails;
import my.entity.auto.Brand;
import my.entity.auto.Model;
import org.junit.Before;
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

    @Before
    public void init() {
        Model bmv = new Model(null, 1, "bmv");
        Brand x5 = new Brand(null, bmv, "X5");

        autoService.addAuto(new Auto());
        modelService.addModel(bmv);
    }

    @Test
    public void crudRepositoryTest() {
        System.out.println(autoService.existsById(1));
        Auto auto = autoService.findById(1);
        System.out.println(auto);

        Model model = modelService.findById(1);

        auto.setModel(model);
        auto.setColour("red");
        auto.setPrice(new BigDecimal(10000));
        autoService.addAuto(auto);
        System.out.println(auto);

        autoService.deleteById(1);
        modelService.deleteById(1);
        //autoDetailsService.deleteById(1);

    }

}


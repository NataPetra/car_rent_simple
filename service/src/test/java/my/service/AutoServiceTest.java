package my.service;

import my.config.RootConfig;
import my.entity.auto.Auto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AutoServiceTest {

    @Autowired
    private AutoService autoService;

    @Before
    public void init() {
        autoService.addAuto(new Auto());
    }

    @Test
    public void crudRepositoryTest() {
        System.out.println(autoService.existsById(1));
        Auto auto = autoService.findById(1);
        System.out.println(auto);
        //auto.setAge(12);
        autoService.addAuto(auto);
        System.out.println(auto);
        //autoService.delete(auto);
        System.out.println(autoService.existsById(1));
    }

}


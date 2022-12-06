package my.loader;

import my.config.RootConfig;
import my.dao.AutoDao;
import my.entity.auto.Auto;
import my.repository.AutoRepository;
import my.service.AutoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AutoService service
                = new AnnotationConfigApplicationContext(
                        AutoRepository.class,
                        RootConfig.class,
                        AutoService.class,
                        AutoDao.class)
                .getBean("autoService", AutoService.class);

        Auto auto = new Auto();

        service.addAuto(auto);

    }
}

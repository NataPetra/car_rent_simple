package it.academy.web_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"my.repository","my.controller", "my.config", "my.dao", "my.rest", "my.security", "my.servlet"})
@EntityScan("my.entity")
@EnableJpaRepositories("my.repository")
@PropertySource(value = "classpath:/car_rent_DB.jdbc.properties")
public class WebSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringBootApplication.class, args);
    }

}

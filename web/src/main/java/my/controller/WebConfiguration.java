package my.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "my.controller")
@EnableWebMvc
public class WebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/jsp/", ".jsp");
    }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver2(){
//        return new InternalResourceViewResolver("/css/", ".css");
//    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1_000_000);
        return multipartResolver;
    }

}

package my.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
@ComponentScan(basePackages = {"my"})
public class ServiceContextConfig {

    @Bean(name = "simpleHttpClient")
    public HttpClient httpClient1(){
        return HttpClient.newHttpClient();
    }
}

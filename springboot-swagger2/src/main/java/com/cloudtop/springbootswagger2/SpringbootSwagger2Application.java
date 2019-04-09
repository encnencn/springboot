package com.cloudtop.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.cloudtop.springbootswagger2")
public class SpringbootSwagger2Application {
    //http://192.168.4.36:8080/swagger-ui.htm
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger2Application.class, args);
    }

}

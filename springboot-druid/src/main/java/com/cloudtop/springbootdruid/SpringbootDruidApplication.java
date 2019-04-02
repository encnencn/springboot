package com.cloudtop.springbootdruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cloudtop.springbootdruid.mapper")
@SpringBootApplication
public class SpringbootDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDruidApplication.class, args);
    }

}

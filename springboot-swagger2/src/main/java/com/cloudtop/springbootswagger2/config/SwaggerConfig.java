/********************************************** 
 * Project Name:springboot-swagger2 
 * File Name:SwaggerConfig.java  
 * Package Name:com.cloudtop.springbootswagger2.config 
 * Date:2019年04月09日 9:42
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootswagger2.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangyingjie
 * @Title: SwaggerConfig.java
 * @Package com.cloudtop.springbootswagger2.config
 * @Description:
 * @date 2019年04月09日 9:42
 *   //基本配置 用@Configuration注解该类，等价于XML中配置beans；
 *    //项目启动的时候启动swagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    //用@Bean标注方法等价于XML中配置bean
    @Bean
    public Docket swaggerSpringMvcPlugin(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.cloudtop.springbootswagger2.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
            .title("Springboot测试使用 swagger2构建restful api")
                //创建人
            .contact(new Contact("YYJ","htttp://www.so.com","931526599@qq.com"))
                //版本号
            .version("1.0")
                //描述
            .description("API 描述")
                .build();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba.springtest.setup;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * @author juba
 */
@Configuration("swaggerConfig")
public class SwaggerConfig {
    
    
    
    @Bean
    public Docket slSwagger() {
        return getDockel("Token Generator", "1.0.0", "com.juba.springtest.controller.auth", "Please use this token in mongo and snowflake access api request header");
    }
    
    @Bean
    public Docket acSwagger() {
        return getDockel("Mongo Gateway", "1.0.0", "com.juba.springtest.controller.mongo").globalOperationParameters(Arrays.asList(new ParameterBuilder()
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build()));
    }
    
    @Bean
    public Docket rndSwagger() {
        return getDockel("Snoflake Gateway", "1.0.0", "com.juba.springtest.controller.snowflake").globalOperationParameters(Arrays.asList(new ParameterBuilder()
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build()));
    }
    
    private  Docket getDockel(String title,String version, String basePackage){
       return getDockel(title, version, basePackage, "");
    }
    
    private Docket getDockel(String title,String version, String basePackage,String description  ){
               return new Docket(DocumentationType.SWAGGER_2).groupName(title)
                .apiInfo(apiInfo(title, version, description))
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build(); 
    }

    private ApiInfo apiInfo(String title,String version, String description   ) {
        return new ApiInfoBuilder().title(title)
                .description(description)
                .version(version)
                .build();
    }
    
    
}

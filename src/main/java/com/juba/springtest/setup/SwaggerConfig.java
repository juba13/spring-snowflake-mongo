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
    public Docket grSwagger() {
        return getDockel("GR-MODULE-API", "2.0.0", "com.pridesyserp.gr");
    }
    
     @Bean
    public Docket inSwagger() {
        return getDockel("IN-MODULE-API", "2.0.0", "com.pridesyserp.in");
    }
    
    @Bean
    public Docket coreSwagger() {
        return getDockel("CORE-MODULE-API", "2.0.0", "com.pridesyserp.core");
    }
    
    @Bean
    public Docket hrSwagger() {
            return getDockel("HR-MODULE-API", "2.0.0", "com.pridesyserp.hr");
    }
    
    
    @Bean
    public Docket slSwagger() {
        return getDockel("SL-MODULE-API", "2.0.0", "com.pridesyserp.sl");
    }
    
    @Bean
    public Docket acSwagger() {
        return getDockel("AC-MODULE-API", "2.0.0", "com.pridesyserp.ac");
    }
    
    @Bean
    public Docket rndSwagger() {
        return getDockel("RND-MODULE-API", "2.0.0", "com.pridesyserp.rnd");
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
                .build().globalOperationParameters(Arrays.asList(new ParameterBuilder()
                .name("TOKEN")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build())); 
    }

    private ApiInfo apiInfo(String title,String version, String description   ) {
        return new ApiInfoBuilder().title(title)
                .description(description)
                .version(version)
                .build();
    }
}

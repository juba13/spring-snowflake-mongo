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
    
//    @Bean
//    public Docket grSwagger() {
//        return getDockel("GR-MODULE-API", "2.0.0", "com.pridesyserp.gr");
//    }
//    
//     @Bean
//    public Docket inSwagger() {
//        return getDockel("IN-MODULE-API", "2.0.0", "com.pridesyserp.in");
//    }
      // add Authorization field as header all swagger endpoint for token input

    @Bean
    public Docket lastApi() {
         return new Docket(DocumentationType.SWAGGER_2).groupName("Restfulinpeace")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().globalOperationParameters(Arrays.asList(new ParameterBuilder()
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build()));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("mongo-snowflake-example")
                .description(" ")
                .version("2.0")
                .build();
    }
    
}

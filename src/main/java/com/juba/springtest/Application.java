package com.juba.springtest;

import com.juba.springtest.config.interceptor.AuthInterceptor;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebMvcConfigurer {
    
   
    // you need to change context path, and port from here. Becuase if you use fro properties file   exclude path only work for empty context
    
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path","/mongo_snowflake");
        System.setProperty("server.port", "8282");
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    
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
    
    
    // exclude path, can access without token 
    
    public static String[] NONFILTERRING_PATH_PATTERNS =new String[]{
        "/auth/login",
        ",/csrf", 
        "/v2/api-docs", 
        "/swagger-resources/configuration/ui", 
        "/configuration/ui", 
        "/swagger-resources", 
        "/swagger-resources/configuration/security", 
        "/configuration/security", 
        "/swagger-ui.html", 
        "/webjars/**"};
    public static String[] FILTERRING_PATH_PATTERNS =new String[]{"/**"};

    @Autowired
    private AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            
       registry.addInterceptor(authInterceptor)
               .addPathPatterns(FILTERRING_PATH_PATTERNS)
               .excludePathPatterns(Arrays.asList(NONFILTERRING_PATH_PATTERNS));
    }

    
     // cross enable
      
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("POST", "GET", "OPTIONS");
    }

}

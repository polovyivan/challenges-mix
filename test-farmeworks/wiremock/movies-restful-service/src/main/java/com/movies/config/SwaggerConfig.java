package com.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket moviesAPI(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.movies.controller"))
                //.paths(regex("/rest.*"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {

        Contact contact = new Contact("Dilip Sundarraj Youtube Channel","https://www.youtube.com/codewithdilip","");

        StringVendorExtension listVendorExtension = new StringVendorExtension("Code With Dilip", "Online Instructor");
        ApiInfo apiInfo = new ApiInfo("Movies RestFul Service API",
                "Movies RestFul Service",
                "1.0",
                "",
                contact,
                "Movies RestFul Service- Source Code"
        ,"https://github.com/code-with-dilip/learn-wiremock/tree/master/movies-restful-service",
                Arrays.asList(listVendorExtension));
        return apiInfo;
    }
}

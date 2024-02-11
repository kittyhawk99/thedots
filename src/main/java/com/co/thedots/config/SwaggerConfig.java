package com.co.thedots.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("co")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.co.thedots.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
	

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API",
                "째깍악어 API.",
                "V1",
                "Terms of service",
                new Contact("administrator", null, null),
                "License of API", "www.example.com", Collections.emptyList());
    }    
    
}

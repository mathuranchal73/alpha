package com.alpha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 	@Bean
	    public Docket userApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage("com.alpha.controller"))
	                .paths(regex("/v1/user.*"))
	                .build()
	                .apiInfo(metaData());
	    }
	 	
	 	
	 	private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "User Service",
	                "Spring Boot REST API ",
	                "v1.0",
	                "Terms of service",
	                new Contact("Anchal Mathur", "http://github.com/mathuranchal73/", "mathuranchal73@gmail.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }

}

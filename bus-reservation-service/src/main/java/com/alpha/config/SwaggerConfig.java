/**
 * 
 */
package com.alpha.config;


import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Anchal.Mathur
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
        //https://github.com/modelmapper/modelmapper/issues/212
    }

	
	
	@Bean
    public Docket BusReservationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("BRS")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alpha.controller.v1.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }
	
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Alpha - Bus Reservation API")
                .description("Alpha").termsOfServiceUrl("")
                .contact( new Contact("Anchal Mathur", "http://github.com/mathuranchal73/", "mathuranchal73@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }
 	
	private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }
 	


}

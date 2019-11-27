package com.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import brave.sampler.Sampler;



@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackageClasses = { 
		ZuulApplication.class,
		Jsr310JpaConverters.class 
})
public class ZuulApplication {
	
    @Bean
	public Sampler alwaysSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	
}

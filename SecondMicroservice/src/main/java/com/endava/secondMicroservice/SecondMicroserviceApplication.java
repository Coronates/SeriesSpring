package com.endava.secondMicroservice;

import com.endava.config.BatchConfiguration;
import com.endava.resource.AnimeResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackageClasses = SecondMicroserviceApplication.class)
public class SecondMicroserviceApplication {
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SecondMicroserviceApplication.class, args);
	}

}

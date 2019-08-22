package com.endava.ThirdMicroservice;

import com.endava.entity.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ThirdMicroserviceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ThirdMicroserviceApplication.class);

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ThirdMicroserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Vote vote = restTemplate.getForObject(
					"https://peaceful-tor-90220.herokuapp.com/votes", Vote.class);
			LOGGER.info(vote.toString());
		};
	}

}

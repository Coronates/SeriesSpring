package com.endava.FirstMicroservice.config;

import com.endava.FirstMicroservice.repository.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import sun.tools.util.CommandLine;


@EnableMongoRepositories(basePackageClasses = SeriesRepository.class)
@Configuration
public class MongoDBConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(SeriesRepository serieRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {


            }
        };
    }
}

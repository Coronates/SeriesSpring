package com.endava.config;

import com.endava.model.Anime;
import com.endava.processor.SeriesItemProcessor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;



    @Bean
    public SeriesItemProcessor processor(){
        return new SeriesItemProcessor();
    }


    @Bean
    public FlatFileItemWriter<Anime> writer(){
        FlatFileItemWriter<Anime> writer = new FlatFileItemWriter<Anime>();
        writer.setResource(new ClassPathResource("series.csv"));
        DelimitedLineAggregator<Anime> lineAggregator = new DelimitedLineAggregator<Anime>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<Anime> fieldExtractor = new BeanWrapperFieldExtractor<Anime>();
        fieldExtractor.setNames(new String[]{"animeId","name","type","rating","source"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(lineAggregator);
        return writer;



    }
}

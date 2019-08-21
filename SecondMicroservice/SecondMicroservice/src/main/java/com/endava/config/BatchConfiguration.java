package com.endava.config;

import com.endava.model.Anime;
import com.endava.processor.AnimesIdsItemProcessor;
import com.endava.processor.SeriesItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import javax.batch.api.listener.JobListener;
import java.util.List;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    private static final String url = "localhost:8889/anime/top";
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public ItemReader<Integer> restAnimeReader(Environment environment, RestTemplate restTemplate) {
        return new RESTAnimeReaderIds(environment.getRequiredProperty(url), restTemplate);
    }

    @Bean
    public SeriesItemProcessor processor() {return new SeriesItemProcessor();}


    @Bean
    public FlatFileItemWriter<Anime> writer() {
        FlatFileItemWriter<Anime> writer = new FlatFileItemWriter<Anime>();
        writer.setResource(new ClassPathResource("resources/series.csv"));
        DelimitedLineAggregator<Anime> lineAggregator = new DelimitedLineAggregator<Anime>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<Anime> fieldExtractor = new BeanWrapperFieldExtractor<Anime>();
        fieldExtractor.setNames(new String[]{"animeId", "name", "type", "rating", "source"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(lineAggregator);
        return writer;

    }

    @Bean
    public Job getTopByGenre(Step step1) {
        return jobBuilderFactory.get("getTopByGenre")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(ItemReader<Integer> restAnimeReader, SeriesItemProcessor animeProcessor, FlatFileItemWriter<Anime> writer) {
        return stepBuilderFactory.get("step1")
                .<Integer, Anime>chunk(1)
                .reader(restAnimeReader)
                .processor(animeProcessor)
                .writer(writer)
                .build();
    }


}

package com.endava.config;

import com.endava.model.Anime;
import com.endava.processor.SeriesItemProcessor;
import com.endava.reader.RESTAnimeReaderIds;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    //private static final String url = "localhost:8889/anime/top";
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private Resource outputResource = new FileSystemResource("output/animes.csv");

    @Bean
    @StepScope
    ItemReader<Integer> reader(@Value("#{jobParameters[url]}") String urlk, RestTemplate restTemplate)
    {
        return new RESTAnimeReaderIds(urlk,restTemplate);
    }

    @Bean(name="animeProcessor")
    public SeriesItemProcessor processor() {
        return new SeriesItemProcessor();
    }


    @Bean
    public FlatFileItemWriter<Anime> writer() {
        FlatFileItemWriter<Anime> writer = new FlatFileItemWriter<Anime>();
        writer.setResource(outputResource);
        DelimitedLineAggregator<Anime> lineAggregator = new DelimitedLineAggregator<Anime>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<Anime> fieldExtractor = new BeanWrapperFieldExtractor<Anime>();
        fieldExtractor.setNames(new String[]{"animeId", "name", "type", "rating", "source"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(lineAggregator);
        return writer;
    }

    @Bean
    public Job job(Step step1) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(ItemReader<Integer> reader, @Qualifier("animeProcessor") SeriesItemProcessor animeProcessor, FlatFileItemWriter<Anime> writer) {
        return stepBuilderFactory.get("step1")
                .<Integer, Anime>chunk(1)
                .reader(reader)
                .processor(animeProcessor)
                .writer(writer)
                .build();
    }


}
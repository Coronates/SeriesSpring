package com.endava.processor;

import com.endava.model.Anime;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;
@Slf4j
public class SeriesItemProcessor implements ItemProcessor<Integer, Anime> {

//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SeriesItemProcessor.class);
    private static final String URL  = "http://localhost:8889/anime/";
    @Autowired
     RestTemplate restTemplate;

    @Override
    public Anime process(Integer id) throws Exception {

        Anime anime= getAnimeById(id);
        log.info(anime.getName());
        return anime;
    }

    public Anime getAnimeById(Integer anime_id){

        Anime anime = restTemplate.getForObject(URL+anime_id, Anime.class);
        return anime;
    }
}


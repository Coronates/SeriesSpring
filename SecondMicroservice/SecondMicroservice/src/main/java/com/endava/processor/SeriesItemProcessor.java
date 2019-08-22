package com.endava.processor;

import com.endava.model.Anime;
import com.endava.model.AnimeList;
import com.endava.resource.AnimeResource;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class SeriesItemProcessor implements ItemProcessor<Integer, Anime> {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SeriesItemProcessor.class);
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Anime process(Integer id) throws Exception {

        Anime anime= getAnimeById(id);
        LOGGER.info(anime.getName());
        return anime;
    }

    public Anime getAnimeById(Integer anime_id){

        Anime anime = restTemplate.getForObject("localhost:8889/anime/"+anime_id, Anime.class);

        return anime;
    }
}




//
//    private static final Logger LOGG = LoggerFactory.getLogger(AnimeItemProcessor.class);
//    private static final String URI  = "http://localhost:8085/anime/";
//
//    @Override
//    public AnimeDTO processo(Integer animeID) throws Exception {
//
//        return fetchAnimeDataFromAPI(animeID, new RestTemplate());
//    }
//
//    private AnimeDTO fetchAnimeDataFromAPI(Integer animeID, RestTemplate restTemplate)
//    {
//        AnimeDTO anime = restTemplate.getForObject(URI+animeID,AnimeDTO[].class)[0];
//        LOG.info(anime.getName());
//        return anime;
//    }
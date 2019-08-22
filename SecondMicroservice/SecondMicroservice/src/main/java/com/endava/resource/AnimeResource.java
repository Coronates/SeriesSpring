package com.endava.resource;

import com.endava.config.RESTAnimeReaderIds;
import com.endava.model.Anime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class AnimeResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimeResource.class);
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/anime/{anime_id}")
    public Anime getAnimeById(@PathVariable Integer anime_id){
       Anime anime = restTemplate.getForObject("localhost:8889/anime/"+anime_id, Anime.class);

        return anime;
    }

    @GetMapping("/anime/topGenre")
    public void getTopAnimeByGenre(@RequestParam Integer limit, @RequestParam String genre){
        List<Integer> animeIds= Arrays.asList(restTemplate.getForObject("localhost:8889/anime/top?limit="+limit+"&genre="+genre, Integer[].class));

        animeIds.stream()
                .forEach(x -> {
                    Anime anime = restTemplate.getForObject("localhost:8889/anime/"+x, Anime.class);
                    LOGGER.info("processing anime: "+ anime.getAnimeId());
                });

    }
    @GetMapping("/anime/topType")
    public void getTopAnimeByType(@RequestParam Integer limit, @RequestParam String type){
        List<Integer> animeIds= Arrays.asList(restTemplate.getForObject("localhost:8889/anime/top?limit="+limit+"&genre="+type, Integer[].class));

        animeIds.stream()
                .forEach(x -> {
                    Anime anime = restTemplate.getForObject("localhost:8889/anime/"+x, Anime.class);
                    LOGGER.info("processing anime: "+ anime.getAnimeId());
                });

    }



}

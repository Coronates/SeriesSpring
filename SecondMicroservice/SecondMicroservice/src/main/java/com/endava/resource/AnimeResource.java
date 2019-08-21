package com.endava.resource;

import com.endava.model.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeResource {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/anime/{anime_id}")
    Anime getAnimeById(@PathVariable Integer anime_id){
       Anime anime = restTemplate.getForObject("localhost:8889/anime/"+anime_id, Anime.class);

        return anime;





    }

}

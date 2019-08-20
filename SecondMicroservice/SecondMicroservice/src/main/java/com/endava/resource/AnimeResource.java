package com.endava.resource;

import com.endava.model.Anime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeResource {
    private Class<List<Integer>> ParameterizedType;

    @RequestMapping("")
    public List<Anime> getAnime(@RequestParam(required = false) Optional<Integer> limit, @RequestParam(required = false) Optional<String> genre){

       RestTemplate restTemplate= new RestTemplate();
       List<Integer> Seriesids = restTemplate.getForObject("localhost:8889/anime/top?limit="+limit+"&genre="+genre, ParameterizedType<new List<Integer>>);

        RestTemplate restTemplate2= new RestTemplate();





    }

}

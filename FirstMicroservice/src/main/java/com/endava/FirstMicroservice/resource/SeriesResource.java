package com.endava.FirstMicroservice.resource;

import com.endava.FirstMicroservice.model.RequiredSerie;
import com.endava.FirstMicroservice.model.Serie;
import com.endava.FirstMicroservice.repository.SeriesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("")
public class SeriesResource {
    private SeriesRepository serieRepository;

    public SeriesResource(SeriesRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    //first method, it returns a list of anime_ids, the method has two optional parameters to filter de anime_ids
    //by its genre and the number of responses
    @GetMapping("/anime")
    @ResponseBody
        public  List<Integer> getAnimeWithLimit(@RequestParam(required = false) Optional<Integer> limit, @RequestParam(required = false) Optional<String> genre) {
        List<Serie> series= this.serieRepository.findAll();

        return series.stream()
                .filter(x-> x.getGenre().contains(genre.orElseGet(()->"")) )
                .map(Serie::getAnime_id)
                .limit(limit.orElseGet(()->series.size()))
                .collect(Collectors.toList());
        }

     //this method returns an object RequiredSerie with a given ID, for that an internal RequiredSerie object is created
    //but it is instantianted only for visualization purposes
    @GetMapping("/anime/{anime_id}")
      RequiredSerie getSerieById(@PathVariable Integer anime_id){
          List<Serie> series= this.serieRepository.findAll();
        Serie anime= series.stream()
                .filter(x-> x.getAnime_id().equals(anime_id))
                .findAny().orElse(null);
        RequiredSerie rq=new RequiredSerie(anime.getAnime_id(),anime.getName(),anime.getGenre().split(","),
                anime.getType(),anime.getEpisodes(),anime.getRating(),anime.getStudios().split(","), anime.getSource(),
                anime.getMain_cast().split(";"));
        return rq;


    }

    //this method uses streams to get the top 100 animes filtered by genre,type,voice actor,studio  and limit.
    @GetMapping("/anime/top")
    public  List<Integer> getAnimeByRating(@RequestParam(required = false) Optional<Integer> limit, @RequestParam(required = false) Optional<String> genre, @RequestParam(required = false) Optional<String> type, @RequestParam(required = false) Optional<String> studio,@RequestParam(required = false) Optional<String> source,@RequestParam(required = false) Optional<String> mainCast) {

        List<Serie> series= this.serieRepository.findAll();
        return series.stream()
                .filter(x-> x.getGenre().contains(genre.orElseGet(()->"")) )
                .filter(x-> x.getType().contains(type.orElseGet(()->"")) )
                .filter(x-> x.getSource().contains(source.orElseGet(()->"")) )
                .filter(x-> x.getMain_cast().contains(mainCast.orElseGet(()->"")) )
                .filter(x-> x.getStudios().contains(studio.orElseGet(()->"")))
                .sorted(Comparator.comparingDouble(Serie::getRating).reversed())
                .map(Serie::getAnime_id)
                .limit(limit.orElseGet(()->100))
                .collect(Collectors.toList())
                ;

    }


}

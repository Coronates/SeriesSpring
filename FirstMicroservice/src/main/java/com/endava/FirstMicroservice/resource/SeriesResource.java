package com.endava.FirstMicroservice.resource;

import com.endava.FirstMicroservice.model.Serie;
import com.endava.FirstMicroservice.repository.SeriesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("")
public class SeriesResource {
    private SeriesRepository serieRepository;

    public SeriesResource(SeriesRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping("/anime")
    public List<Integer> getAll(){
//        List<Serie> series= this.serieRepository.findAll();
//       List<Integer> idSeries= Stream.of(series).
//                map(series-> series.contains());
//        return idSeries;


    }
    @GetMapping("/anime/limit")
    public List<Serie> getAnimeByLimit(){
        List<Serie> series= this.serieRepository.findAll();
        return series;


    }
    @GetMapping("/anime/genre")
    public List<Serie> getAllByGenre(){
        List<Serie> series= this.serieRepository.findAll();
        return series;


    }
    @GetMapping("/anime/{id}")
    public Serie getSerieById(@PathVariable("{anime_id}") Integer id){
        Serie serie =this.serieRepository.findByIds(id);
        return serie;
    }
}

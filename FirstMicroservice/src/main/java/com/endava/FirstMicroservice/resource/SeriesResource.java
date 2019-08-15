package com.endava.FirstMicroservice.resource;

import com.endava.FirstMicroservice.model.Serie;
import com.endava.FirstMicroservice.repository.SeriesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/series")
public class SeriesResource {
    private SeriesRepository serieRepository;

    public SeriesResource(SeriesRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping("/all")
    public List<Serie> getAll(){
        return serieRepository.findAll();


    }
}

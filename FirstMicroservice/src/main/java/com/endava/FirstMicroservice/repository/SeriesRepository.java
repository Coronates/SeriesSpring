package com.endava.FirstMicroservice.repository;


import com.endava.FirstMicroservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<Serie, String> {
        //public Serie findSerieByanimeid(Integer anime_id);
}

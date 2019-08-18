package com.endava.FirstMicroservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class RequiredSerie {
    private Integer animeId;
    private String name;
    private String[] genre;
    private String type;
    private Integer episodes;
    private Double rating;
    private String[] studios;
    private String source;
    private String[] main_cast;

    public RequiredSerie(Integer animeId, String name, String[] genre, String type, Integer episodes, Double rating, String[] studios, String source, String[] main_cast) {
        this.animeId = animeId;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.studios = studios;
        this.source = source;
        this.main_cast = main_cast;
    }
}

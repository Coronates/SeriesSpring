package com.endava.model;

import lombok.Data;

@Data
public class Anime {

    private Integer animeId;
    private String name;
    private String[] genre;
    private String type;
    private Integer episodes;
    private Double rating;
    private String[] studios;
    private String source;
    private String[] main_cast;
}
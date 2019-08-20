package com.endava.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Anime {

    private Integer anime_id;
    private String name;
    private String type;
    private Double rating;
    private String source;



}

package com.endava.FirstMicroservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "CTF")
public class Serie {
    @Id
    private String _id;
//    @Indexed(unique = true)
    private Integer anime_id;
    private String name;
    private String genre;
    private String type;
    private Integer episodes;
    private Double rating;
    private String img;
    private String studios;
    private String source;
    private String main_cast;
    private Integer c1;
    private Integer c2;
    private Integer members;


}

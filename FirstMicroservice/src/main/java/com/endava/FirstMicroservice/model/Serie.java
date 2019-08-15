package com.endava.FirstMicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "CTF")
public class Serie {
    @Id
    private String _id;
    private Integer anime_id;
    private String name;
    private String genre;
    private String type;
    private Integer episodes;
    private Double rating;
    private String img;
    private String studio;
    private String source;
    private String main_cast;
    private Integer c1;
    private Integer c2;
    private Integer members;

    public Serie(String _id, Integer anime_id, String name, String genre, String type, Integer episodes, Double rating, String img, String studio, String source, String main_cast, Integer c1, Integer c2, Integer members) {
        this._id = _id;
        this.anime_id = anime_id;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.img = img;
        this.studio = studio;
        this.source = source;
        this.main_cast = main_cast;
        this.c1 = c1;
        this.c2 = c2;
        this.members = members;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Integer anime_id) {
        this.anime_id = anime_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMain_cast() {
        return main_cast;
    }

    public void setMain_cast(String main_cast) {
        this.main_cast = main_cast;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }
}

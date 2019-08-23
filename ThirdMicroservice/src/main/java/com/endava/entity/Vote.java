package com.endava.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Vote")
@Data
public class Vote {


    @Column(name="when")
    private String when;

    @Column(name="user")
    private String user;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movie_id")
    private Integer movie_id;

    @Column(name="rating")
    private Double rating;

    public Vote(){}



}

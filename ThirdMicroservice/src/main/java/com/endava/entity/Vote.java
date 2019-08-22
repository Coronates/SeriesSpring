package com.endava.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Vote")
@Data
public class Vote {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movie_id")
    private Integer movie_id;

    @Column(name="when")
    private Date when;

    @Column(name="user")
    private String user;

    @Column(name="rating")
    private Double rating;



}

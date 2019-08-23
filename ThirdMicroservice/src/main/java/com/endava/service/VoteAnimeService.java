package com.endava.service;

import com.endava.entity.Vote;
import com.endava.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class VoteAnimeService {
    @Autowired
    private VoteRepository voteRepository;


    private String baseUrl;
    private final String URI = "https://peaceful-tor-90220.herokuapp.com/votes?since=";
    @Autowired
    private RestTemplate template;

//    @Autowired
//    public VoteAnimeService(RestTemplate template,@Value"${service.url}"baseUrl){
//        this.template = template;
//        this.baseUrl = baseUrl;
//    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public Iterable<Vote> save(List<Vote> votes){
        return voteRepository.saveAll(votes);
    }
    public Iterable<Vote> list(){
        return voteRepository.findAll();
    }





}

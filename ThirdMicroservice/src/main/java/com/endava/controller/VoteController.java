package com.endava.controller;

import com.endava.entity.Vote;
import com.endava.repository.VoteRepository;
import com.endava.service.VoteAnimeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("")
public class VoteController {
    private VoteAnimeService voteAnimeService;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private RestTemplate template;

    private final String URI = "https://peaceful-tor-90220.herokuapp.com/votes?since=";

    public VoteController(VoteAnimeService voteAnimeService) {
        this.voteAnimeService = voteAnimeService;
    }



    public Vote createVote(Vote vote) {
        return voteAnimeService.save(vote);
    }

    @GetMapping("/list")
    public List<Vote> getVotes(){
        return (List<Vote>) voteAnimeService.save(getVotesAsObjects());
    }

    public List<Vote> getVotesAsObjects(){
        String data= template.getForObject(URI, String.class);
        List<String> listObjects= Arrays.asList(data.split("\\}"));
        List<Vote> voteList= new ArrayList<>();
        Gson gson= new Gson();
        for(int i=0; i< listObjects.size(); i++){
            listObjects.set(i, listObjects.get(i)+"}");
        }

        for(int i=0; i< listObjects.size(); i++){
            voteList.add(gson.fromJson(listObjects.get(i),Vote.class));
        }
        return voteList;
    }


}

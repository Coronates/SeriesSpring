package com.endava.service;

import com.endava.entity.Vote;
import com.endava.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VoteAnimeService {
    @Autowired
    private VoteRepository voteRepository;
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }
    @Autowired
    private RestTemplate template;

    private String baseUrl;

    @Autowired
    public VoteAnimeService(RestTemplate template,@Value"${service.url}"baseUrl){
        this.template = template;
        this.baseUrl = baseUrl;
    }

    public List<Vote> getVotesAsObjects(){
         String data= template.getForObject("https://peaceful-tor-90220.herokuapp.com/votes", String.class);
         List<String> listObjects= Arrays.asList(data.split("\\{\\}"));


    }
}

package com.endava.controller;

import com.endava.entity.Vote;
import com.endava.service.VoteAnimeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
    private VoteAnimeService voteAnimeService;
    public Vote createVote(Vote vote){
        return voteAnimeService.createVote(vote);

    }
}

package com.endava.resource;

import com.endava.config.RESTAnimeReaderIds;
import com.endava.model.Anime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/getTop")
public class AnimeResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimeResource.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;

    public JobParameters getJobParameters(String URL) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("uri", URL);
        return jobParametersBuilder.toJobParameters();
    }





    @GetMapping("/topAnimeByGenre")
    public void topByGenre(@RequestParam Integer limit, @RequestParam String genre) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String url2 = "http://localhost:8889/anime/top?limit="+limit+"&genre="+genre;
        jobLauncher.run(job,getJobParameters(url2));
    }

    @GetMapping("/topByType")
    public void topAnimeByType(
            @RequestParam Integer limit,
            @RequestParam String type) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String url1 = "http://localhost:8889/anime/top?limit="+limit+"&type="+type;
        jobLauncher.run(job,getJobParameters(url1));
    }

    @GetMapping("/topByStudioAndVoice")
    public void topAnimeByType(@RequestParam Integer limit,@RequestParam String mainCast,@RequestParam String studio) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String url3 = "http://localhost:8889/anime/top?limit="+limit+"&studio="+studio+"&mainCast="+mainCast;
        jobLauncher.run(job,getJobParameters(url3));
    }



}





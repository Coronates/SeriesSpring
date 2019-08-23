package com.endava.resource;

import com.endava.processor.SeriesItemProcessor;
import com.endava.processor.SeriesItemProcessor;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AnimeResource {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    private static final Logger LOG = LoggerFactory.getLogger(SeriesItemProcessor.class);


    public JobParameters getJobParameters(String URL) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("url", URL);
        return jobParametersBuilder.toJobParameters();
    }

    @GetMapping("/getTop/ByGenre")
    public String topAnimeByGenre(
            @RequestParam Integer limit,
            @RequestParam String genre) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String URL = "http://localhost:8889/anime/top?limit="+limit+"&genre="+genre;
        LOG.info(URL);
        jobLauncher.run(job,getJobParameters(URL));
        return "String";

    }
    @GetMapping("/prueba")
    public String topAnimeByGenre(){

        return "hola";
    }

    @GetMapping("/getTop/ByType")
    public String topAnimeByType(
            @RequestParam Integer limit,
            @RequestParam String type) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String URL = "http://localhost:8889/anime/top?limit="+limit+"&type="+type;
        jobLauncher.run(job,getJobParameters(URL));
        return "success";
    }

    @GetMapping("/getTop/ByStudio")
    public String topAnimeByType(
            @RequestParam Integer limit,
            @RequestParam String mainCast,
            @RequestParam String studio) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String URL = "http://localhost:8889/anime/top?limit="+limit+"&mainCast="+mainCast+"&studio="+studio;
        jobLauncher.run(job,getJobParameters(URL));
        return "Success";
    }




}





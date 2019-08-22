package com.endava.config;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

public class RESTAnimeReaderIds implements ItemReader<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTAnimeReaderIds.class);


    private final RestTemplate restTemplate;
    private final String urlll;
    private int nextAnimeIndex;
    private List<Integer> animes;


    
    RESTAnimeReaderIds(String urll,RestTemplate restTemplate) {
        this.urlll = urll;
        this.restTemplate = restTemplate;
        nextAnimeIndex = 0;
    }

    @Override
    public Integer read() throws Exception {
        LOGGER.info("Reading anime ids");
        if (listIsEmpty()) {
            animes = getAnimesIdsFromAPI();
        }
        Integer nextAnimeId=0;
        if (nextAnimeIndex < animes.size()) {
            nextAnimeId = animes.get(nextAnimeIndex);
            nextAnimeIndex++;
        }
        LOGGER.info("Found anime: {}", nextAnimeId);
        return nextAnimeId;
    }

    private boolean listIsEmpty() {
        return this.animes == null;
    }

    private List<Integer> getAnimesIdsFromAPI() {
        LOGGER.debug("Anime ids from external API by using the url: {}"+urlll);
        Integer[] ids = restTemplate.getForObject(urlll,Integer[].class);

        LOGGER.debug("Found {} animes", ids);
        return Arrays.asList(ids);
    }
}

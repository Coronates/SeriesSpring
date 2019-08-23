package com.endava.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RESTAnimeReaderIds implements ItemReader<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTAnimeReaderIds.class);


    private final RestTemplate restTemplate;
    private final String url;
    private int nextAnimeIndex;
    private List<Integer> animes;


    
    public RESTAnimeReaderIds(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
        nextAnimeIndex = 0;
    }

    @Override
    public Integer read() throws Exception {
        LOGGER.info("Reading anime ids");
        if (listIsEmpty()) {
            animes = getAnimesIdsFromAPI();
        }
        Integer nextAnimeId=null;
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
        LOGGER.debug("Anime ids from external API by using the url: {}"+url);
        Integer[] ids = restTemplate.getForObject(url,Integer[].class);

        LOGGER.debug("Found {} animes", ids);
        return Arrays.asList(ids);
    }
}

package com.endava.processor;

import com.endava.model.Anime;
import com.endava.model.AnimeList;
import com.endava.model.AnimeListIds;
import com.endava.resource.AnimeResource;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;
import java.util.logging.Logger;


public class AnimesIdsItemProcessor implements ItemProcessor<AnimeListIds,AnimeList> {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(AnimesIdsItemProcessor.class);

    @Override
    public AnimeList process(AnimeListIds ids) throws Exception {
        AnimeList animes = new AnimeList();
        List<Anime> accumulator = null;

        for(int i =0; i<ids.getAnimeids().size();i++){
            AnimeResource ar = new AnimeResource();
            accumulator.add(ar.getAnimeById(i));
        }



        return animes;


    }
}

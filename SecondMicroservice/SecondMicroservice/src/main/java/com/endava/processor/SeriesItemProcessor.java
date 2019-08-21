package com.endava.processor;

import com.endava.model.Anime;
import com.endava.model.AnimeList;
import com.endava.resource.AnimeResource;
import org.springframework.batch.item.ItemProcessor;

public class SeriesItemProcessor implements ItemProcessor<Integer, Anime> {
    @Override
    public Anime process(Integer id) throws Exception {
        AnimeResource ar=new AnimeResource();
        return ar.getAnimeById(id);
    }
}

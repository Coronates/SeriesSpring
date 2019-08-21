package com.endava.processor;

import com.endava.model.Anime;
import com.endava.model.AnimeList;
import com.endava.model.AnimeListIds;
import com.endava.resource.AnimeResource;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;
import java.util.logging.Logger;


public class AnimesItemProcessor implements ItemProcessor<AnimeList,Anime> {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(AnimesItemProcessor.class);

    @Override
    public Anime process(AnimeList animes) throws Exception {

        Anime a = new Anime();
        for(Anime anim : animes.getAnimes()){
            AnimeResource ar = new AnimeResource();
            if(ar.getAnimeById(anim.getAnimeId()).equals(anim))
            {
                a=anim;
            };
        }
        return a;

    }
}

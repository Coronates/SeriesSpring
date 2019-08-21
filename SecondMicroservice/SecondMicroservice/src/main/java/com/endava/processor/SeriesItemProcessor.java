package com.endava.processor;

import com.endava.model.Anime;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.logging.Logger;


public class SeriesItemProcessor implements ItemProcessor<Anime,Anime> {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(SeriesItemProcessor.class);

    @Override
    public Anime process(Anime item) throws Exception {
        Integer animeId=item.getAnime_id();
        String name = item.getName();
        String type= item.getType();
        Double rating = item.getRating();
        String source= item.getSource();

        Anime anime = new Anime();
        anime.setAnime_id(animeId);
        anime.setType(type);
        anime.setName(name);
        anime.setRating(rating);
        anime.setSource(source);

        Anime anime2 = new Anime();
        anime.setAnime_id(animeId);
        anime.setType(type);
        anime.setName(name);
        anime.setRating(rating);
        anime.setSource(source);


        LOG.info("Convirtiendo ("+item+") a ("+anime+")");

        return anime;
    }
}

package com.endava.FirstMicroservice.resource;

import com.endava.FirstMicroservice.model.RequiredSerie;
import com.endava.FirstMicroservice.repository.SeriesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class SeriesResourceTest {
    @Mock
    SeriesRepository serieRepository;
    @InjectMocks
    SeriesResource seriesResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAnimeWithLimit() throws Exception {

        List<Integer> result = seriesResource.getAnimeWithLimit(Optional.of(10), Optional.of("Action"));
        Assert.assertEquals(Arrays.<Integer>asList(2169,2592,3227,31050,27967,34430,32271,34299,31678,3786), result);
    }

    @Test
    public void testGetSerieById() throws Exception {
        RequiredSerie result = seriesResource.getSerieById(263);
        Assert.assertEquals(new RequiredSerie(263, "Hajime no Ippo", new String[]{"Comedy","Drama","Shounen","Sports"}, "TV", 75, 8.83, new String[]{"MadHouse"}, "Manga", new String[]{"Takagi,Wataru","Utsumi,Kenji","Fujiwara,Keiji","Kiyasu,Kohei","Koyama,Rikiya"}), result);
    }

    @Test
    public void testGetAnimeByRating() throws Exception {
        List<Integer> result = seriesResource.getAnimeByRating(Optional.of(7), Optional.of("Shounen"), null, Optional.of("Production I.G"), null, null);
        Assert.assertEquals(Arrays.<Integer>asList(32935,28891,20583,24415,16894,30230,11771), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
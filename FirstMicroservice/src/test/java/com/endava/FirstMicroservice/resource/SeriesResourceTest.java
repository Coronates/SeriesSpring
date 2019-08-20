package com.endava.FirstMicroservice.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class SeriesResourceTest {
    @Mock
    com.endava.FirstMicroservice.repository.SeriesRepository serieRepository;
    @InjectMocks
    com.endava.FirstMicroservice.resource.SeriesResource seriesResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAnimeWithLimit() throws Exception {
        java.util.List<java.lang.Integer> result = seriesResource.getAnimeWithLimit(null, null);
        Assert.assertEquals(java.util.Arrays.<java.lang.Integer>asList(Integer.valueOf(0)), result);
    }

    @Test
    public void testGetSerieById() throws Exception {
        com.endava.FirstMicroservice.model.RequiredSerie result = seriesResource.getSerieById(Integer.valueOf(0));
        Assert.assertEquals(new com.endava.FirstMicroservice.model.RequiredSerie(Integer.valueOf(0), "name", new java.lang.String[]{"genre"}, "type", Integer.valueOf(0), Double.valueOf(0), new java.lang.String[]{"studios"}, "source", new java.lang.String[]{"main_cast"}), result);
    }

    @Test
    public void testGetAnimeByRating() throws Exception {
        java.util.List<java.lang.Integer> result = seriesResource.getAnimeByRating(null, null, null, null, null, null);
        Assert.assertEquals(java.util.Arrays.<java.lang.Integer>asList(Integer.valueOf(0)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
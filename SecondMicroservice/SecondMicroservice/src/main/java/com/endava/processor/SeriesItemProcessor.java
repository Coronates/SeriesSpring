package com.endava.processor;

import org.springframework.batch.item.ItemProcessor;


public class SeriesItemProcessor implements ItemProcessor<FormattedSeries,FormattedSeries> {

    @Override
    public FormattedSeries process(FormattedSeries formattedSeries) throws Exception {
        return null;
    }
}

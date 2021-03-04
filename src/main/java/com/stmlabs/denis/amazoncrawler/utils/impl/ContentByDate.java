package com.stmlabs.denis.amazoncrawler.utils.impl;

import com.stmlabs.denis.amazoncrawler.database.repos.CollectedParametersRepository;
import com.stmlabs.denis.amazoncrawler.pojo.Content;
import com.stmlabs.denis.amazoncrawler.utils.ContentBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class ContentByDate implements ContentBy {
    @Autowired
    CollectedParametersRepository collectedParametersRepository;

    private Date date;

    public ContentByDate(Date date) {
        this.date = date;
    }

    public List<Content> getForRegion(String region) {
        List<Content> contents = collectedParametersRepository.getContentByDateAndRegion(date, region);
        return contents;
    }
}

package com.stmlabs.denis.amazoncrawler.utils.impl;

import com.stmlabs.denis.amazoncrawler.database.repos.CollectedParametersRepository;
import com.stmlabs.denis.amazoncrawler.pojo.Content;
import com.stmlabs.denis.amazoncrawler.utils.ContentBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentByParserId implements ContentBy {
    @Autowired
    CollectedParametersRepository collectedParametersRepository;

    private int parserId;

    public ContentByParserId(int parserId) {
        this.parserId = parserId;
    }

    public List<Content> getForRegion(String region) {
        List<Content> contents = collectedParametersRepository.getContentByParserIdAndRegion(parserId, region);
        return contents;
    }
}

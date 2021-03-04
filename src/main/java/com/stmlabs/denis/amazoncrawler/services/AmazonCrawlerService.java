package com.stmlabs.denis.amazoncrawler.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stmlabs.denis.amazoncrawler.database.repos.RegionRepository;
import com.stmlabs.denis.amazoncrawler.pojo.Content;
import com.stmlabs.denis.amazoncrawler.pojo.OutputJson;
import com.stmlabs.denis.amazoncrawler.utils.ContentBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmazonCrawlerService {
    @Autowired
    RegionRepository regionRepository;

    public List<OutputJson> getOutputJson(ContentBy contentBy) {
        List<OutputJson> outputJsons = new ArrayList<>();

        List<String> regions = regionRepository.getRegionNames();
        for(String region : regions) {
            List<Content> contents = contentBy.getForRegion(region);
            if(!contents.isEmpty()) {
                outputJsons.add(new OutputJson(region, contents));
            }
        }

        return outputJsons;
    }
}

package com.stmlabs.denis.amazoncrawler.utils;

import com.stmlabs.denis.amazoncrawler.pojo.Content;

import java.util.List;

public interface ContentBy {
    List<Content> getForRegion(String region);
}

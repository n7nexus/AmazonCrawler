package com.stmlabs.denis.amazoncrawler;

import java.util.List;

public class OutputJson {
    String region;
    List<Content> contents;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public OutputJson(String region, List<Content> contents) {
        this.region = region;
        this.contents = contents;
    }
}

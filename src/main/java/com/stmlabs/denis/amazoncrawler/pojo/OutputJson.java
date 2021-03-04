package com.stmlabs.denis.amazoncrawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OutputJson {
    String region;
    List<Content> contents;
}

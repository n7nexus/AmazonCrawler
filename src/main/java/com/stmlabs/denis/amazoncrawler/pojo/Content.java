package com.stmlabs.denis.amazoncrawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Content {
    private Integer id;
    private Integer pid;
    private String value;
    private String tpName;
}

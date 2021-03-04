package com.stmlabs.denis.amazoncrawler.database.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String value;

}

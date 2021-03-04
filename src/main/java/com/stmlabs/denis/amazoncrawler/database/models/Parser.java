package com.stmlabs.denis.amazoncrawler.database.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Parser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    private java.sql.Date date;

}

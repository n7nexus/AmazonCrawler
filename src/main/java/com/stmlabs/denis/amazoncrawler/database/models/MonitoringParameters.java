package com.stmlabs.denis.amazoncrawler.database.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "monitoring_parameters")
@Data
public class MonitoringParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

}


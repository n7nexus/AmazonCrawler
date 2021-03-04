package com.stmlabs.denis.amazoncrawler.database.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "collected_parameters")
@Data
public class CollectedParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer pid;

    private String value;

    @OneToOne
    @JoinColumn(name = "id_parser", referencedColumnName = "id")
    private Parser parser;

    @OneToOne
    @JoinColumn(name = "id_monitoring_parameters", referencedColumnName = "id")
    private MonitoringParameters monitoringParameter;

    @OneToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id")
    private Region region;

}

package com.stmlabs.denis.amazoncrawler;

import javax.persistence.*;

@Entity
@Table(name = "collected_parameters")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Parser getParserId() {
        return parser;
    }

    public void setParserId(Parser parser) {
        this.parser = parser;
    }

    public MonitoringParameters getMonitoringParameter() {
        return monitoringParameter;
    }

    public void setMonitoringParameter(MonitoringParameters monitoringParameter) {
        this.monitoringParameter = monitoringParameter;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

//    @Column(name = "id_parser")
//    private Integer parserId;
//
//    @Column(name = "id_monitoring")
//    private Integer monitoringId;
//
//    @Column(name = "id_region")
//    private Integer regionId;

}

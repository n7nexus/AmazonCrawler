package com.stmlabs.denis.amazoncrawler;

public class Content {
    private Integer id;
    private Integer pid;
    private String value;
    private String tpName;

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

    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName;
    }

    public Content(Integer id, Integer pid, String value, String tpName) {
        this.id = id;
        this.pid = pid;
        this.value = value;
        this.tpName = tpName;
    }
}

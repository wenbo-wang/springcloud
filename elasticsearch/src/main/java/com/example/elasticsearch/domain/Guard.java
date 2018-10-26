package com.example.elasticsearch.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * A guard.control.
 */
@Document(indexName = "guard")
public class Guard implements  Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String st;

    private String swIp;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Guard name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSt() {
        return st;
    }

    public Guard st(String st) {
        this.st = st;
        return this;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getSwIp() {
        return swIp;
    }

    public Guard swIp(String swIp) {
        this.swIp = swIp;
        return this;
    }

    public void setSwIp(String swIp) {
        this.swIp = swIp;
    }


}

package com.cssl.entity;

import java.io.Serializable;

public class Options implements Serializable {
    private Integer oid;
    private String content;
    private Integer osid;
    private Integer opoll;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOsid() {
        return osid;
    }

    public void setOsid(Integer osid) {
        this.osid = osid;
    }

    public Options(Integer oid, String content, Integer osid) {
        this.oid = oid;
        this.content = content;
        this.osid = osid;
    }

    public Options(String content, Integer osid) {
        this.content = content;
        this.osid = osid;
    }

    public Options() {
    }

    public Integer getOpoll() {
        return opoll;
    }

    public void setOpoll(Integer opoll) {
        this.opoll = opoll;
    }

    @Override
    public String toString() {
        return "Options{" +
                "oid=" + oid +
                ", content='" + content + '\'' +
                ", osid=" + osid +
                ", opoll=" + opoll +
                '}';
    }

    public Options(String content) {
        this.content = content;
    }
}

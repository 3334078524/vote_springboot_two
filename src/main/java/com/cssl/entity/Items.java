package com.cssl.entity;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {
    private Integer iid;
    private Integer uid;
    private Integer sid;
    private Integer oid;
    private User user;
    private List<Options> options;
    private Subject subject;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Items(Integer iid, Integer uid, Integer sid, Integer oid) {
        this.iid = iid;
        this.uid = uid;
        this.sid = sid;
        this.oid = oid;
    }

    public Integer getIid() {
        return iid;
    }

    public Items(Integer uid, Integer sid, Integer oid) {
        this.uid = uid;
        this.sid = sid;
        this.oid = oid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Items() {
    }

    @Override
    public String toString() {
        return "Items{" +
                "iid=" + iid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", oid=" + oid +
                ", user=" + user +
                ", options=" + options +
                ", subject=" + subject +
                '}';
    }
}

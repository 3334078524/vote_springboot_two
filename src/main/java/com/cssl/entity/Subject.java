package com.cssl.entity;

import java.io.Serializable;
import java.util.List;

public class Subject implements Serializable {
    private Integer sid;
    private String title;
    private Integer type;
    //选项
    private Integer choose;
    //票数
    private Integer poll;
    //所有的选项
    private List<String> allOptions;

    public List<String> getAllOptions() {
        return allOptions;
    }

    public void setAllOptions(List<String> allOptions) {
        this.allOptions = allOptions;
    }

    public Integer getChoose() {
        return choose;
    }

    public void setChoose(Integer choose) {
        this.choose = choose;
    }

    public Integer getPoll() {
        return poll;
    }

    public void setPoll(Integer poll) {
        this.poll = poll;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Subject(Integer sid, String title, Integer type) {
        this.sid = sid;
        this.title = title;
        this.type = type;
    }

    public Subject(String title, Integer type) {
        this.title = title;
        this.type = type;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "sid=" + sid +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", choose=" + choose +
                ", poll=" + poll +
                '}';
    }
}

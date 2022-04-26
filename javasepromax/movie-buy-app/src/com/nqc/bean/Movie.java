package com.nqc.bean;

import java.util.Date;

public class Movie {
    private String name;
    private String actor;
    private double score;
    private Date startTime;
    private double price;
    private double number;//余票
    private double time;

    public Movie() {
    }

    public Movie(String name, String actor, Date startTime, double price, double number, double time) {
        this.name = name;
        this.actor = actor;
        this.startTime = startTime;
        this.price = price;
        this.number = number;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}

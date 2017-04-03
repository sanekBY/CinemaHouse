package com.sashqua.cinema.entity;

import java.util.Date;
import java.util.List;
/**
 * CinemaHouse project
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public class Movie {

    private Integer id;
    private String name;
    private Integer ageLimit;
    private Double duration;

    public Movie() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}

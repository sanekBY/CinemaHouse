package com.sashqua.cinema.dao;

import com.sashqua.cinema.entity.Movie;

import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public interface MovieDAO {
    public Movie getMovie(Integer id);
    public void setMovie(Movie movie);
    public List<Movie> findAll();
}

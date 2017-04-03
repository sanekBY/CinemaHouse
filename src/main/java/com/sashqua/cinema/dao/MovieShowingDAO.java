package com.sashqua.cinema.dao;

import com.sashqua.cinema.entity.MovieShowing;

import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public interface MovieShowingDAO {
    public MovieShowing getMovieShowing(Integer id);
    public void addMovieShowing(MovieShowing movieShowing);
    public List<MovieShowing> findAll();
}

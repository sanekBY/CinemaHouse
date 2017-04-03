package com.sashqua.cinema.service;

import com.sashqua.cinema.entity.MovieShowing;

import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public interface MovieShowingService {
    public MovieShowing getMovieShowing(Integer id);
    public List<MovieShowing> findAll();
}

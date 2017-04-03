package com.sashqua.cinema.service.impl;

import com.sashqua.cinema.dao.MovieShowingDAO;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.service.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@Service("movieShowingService")
public class MovieShowingServiceImpl implements  MovieShowingService{
    @Autowired
    MovieShowingDAO movieShowingDAO;

    @Override
    public MovieShowing getMovieShowing(Integer id) {
        return movieShowingDAO.getMovieShowing(id);
    }

    @Override
    public List<MovieShowing> findAll() {
        return movieShowingDAO.findAll();
    }


}

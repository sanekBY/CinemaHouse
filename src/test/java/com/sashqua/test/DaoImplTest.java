package com.sashqua.test;

import com.sashqua.cinema.dao.impl.MovieDAOImpl;
import com.sashqua.cinema.dao.impl.MovieShowingDAOImpl;
import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public class DaoImplTest {
    @Test
    public void checkMovieShowingDao() {
        MovieShowingDAOImpl movieShowingDAO = new MovieShowingDAOImpl();
        List<MovieShowing> movieShowings = new ArrayList<>();
        movieShowings.addAll(movieShowingDAO.findAll());
        MovieShowing movieShowing = new MovieShowing();
        movieShowing = movieShowingDAO.getMovieShowing(1);
        System.out.println(movieShowings);
    }

    @Test
    public void checkMovie() {
        MovieDAOImpl movieDAO = new MovieDAOImpl();
        List<Movie> movieList = new ArrayList<>();
        movieList.addAll(movieDAO.findAll());
        System.out.println(movieList);
    }
}

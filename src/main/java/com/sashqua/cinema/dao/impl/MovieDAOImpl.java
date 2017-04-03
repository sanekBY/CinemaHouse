package com.sashqua.cinema.dao.impl;

import com.sashqua.cinema.dao.MovieDAO;
import com.sashqua.cinema.dao.MovieShowingDAO;
import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@Repository
public class MovieDAOImpl implements MovieDAO {
    Properties props = new Properties();

    public MovieDAOImpl() {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/Schedule.dat");
            props.load(in);
            in.close();
//            OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream("src/main/example.dat"), "UTF-8");
//            props.setProperty("FIRST_NAME", String.valueOf(user.getFirstName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getMovie(Integer id) {
        return null;
    }

    @Override
    public void setMovie(Movie movie) {

    }

    @Override
    public List<Movie> findAll() {
        List<Movie> allMovies = new ArrayList<>();
        try {
            for (int i = 1; i <= Integer.valueOf(props.getProperty("movie.num")); ++i) {
                Movie movie = new Movie();
                movie.setId(i);
                movie.setName(props.getProperty("movie.name."+i));
                movie.setAgeLimit(Integer.parseInt(props.getProperty("movie.agelimit." + i)));
                movie.setDuration(Double.parseDouble(props.getProperty("movie.duration." + i)));
                allMovies.add(movie);
            }
        } catch (Exception ex) {}
        return allMovies;
    }
}

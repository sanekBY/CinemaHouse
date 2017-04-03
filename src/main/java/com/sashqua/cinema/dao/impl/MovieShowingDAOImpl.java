package com.sashqua.cinema.dao.impl;

import com.sashqua.cinema.dao.MovieShowingDAO;
import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
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
public class MovieShowingDAOImpl implements MovieShowingDAO {

    MovieDAOImpl movieDAO;
    Properties props;
    List<Movie> allMovies;

    public MovieShowingDAOImpl() {
        try {
            props = new Properties();
            allMovies = new ArrayList<>();
            movieDAO = new MovieDAOImpl();
            allMovies.addAll(movieDAO.findAll());
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
    public MovieShowing getMovieShowing(Integer id) {
        MovieShowing movieShowing = new MovieShowing();
        try {
            movieShowing.setId(id);
            movieShowing.setDateOfShow(new Date());
            for (Movie movie : allMovies) {
                if (movie.getId() == Integer.parseInt(props.getProperty("showing.movie."+id))) {
                    movieShowing.setMovie(movie);
                }
            }
            movieShowing.setAllTickets(ticketsGen());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        if (movieShowing.getMovie() == null) return null;
        else return movieShowing;
    }

    @Override
    public void addMovieShowing(MovieShowing movieShowing) {
    }

    @Override
    public List<MovieShowing> findAll() {
        List<MovieShowing> allMovieShowings = new ArrayList<>();
        try {
            for (int i = 1; i <= Integer.valueOf(props.getProperty("showing.num")); ++i) {
                MovieShowing movieShowing = new MovieShowing();
                movieShowing.setId(i);
                movieShowing.setDateOfShow(new Date());
                for (Movie movie : allMovies) {
                    if (movie.getId() == Integer.parseInt(props.getProperty("showing.movie."+i))) {
                        movieShowing.setMovie(movie);
                    }
                }
                movieShowing.setAllTickets(ticketsGen());
                allMovieShowings.add(movieShowing);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
       return allMovieShowings;
    }

    private List<Ticket> ticketsGen() {
        List<Ticket> allTickets = new ArrayList<>();
        int rows = Integer.valueOf(props.getProperty("rows.num"));
        int seats = Integer.valueOf(props.getProperty("seats.num"));
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= seats; ++j) {
                Ticket ticket = new Ticket();
                ticket.setId(allTickets.size());
                ticket.setRow(i);
                ticket.setSeat(j);
                ticket.setPrice(Double.parseDouble(props.getProperty("price")));
                allTickets.add(ticket);
            }
        }
        return allTickets;
    }
}

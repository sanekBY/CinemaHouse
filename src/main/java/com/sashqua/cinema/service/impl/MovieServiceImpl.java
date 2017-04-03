package com.sashqua.cinema.service.impl;

import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.entity.Ticket;
import com.sashqua.cinema.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {


    public static List<Movie> movieList;

    @Override
    public List<Movie> findAll(Integer hallId) {
        return null;
    }

    @Override
    public List<Movie> getByDate(Date date) {
        return null;
    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(Integer id) {

    }

    @Override
    public void getMovie(Integer id) {

    }

    @Override
    public void editMovie(Integer id) {

    }

    @Override
    public void addMoiveShowing(MovieShowing movieShowing) {

    }

    @Override
    public void deleteMoiveShowing(Integer showId) {

    }

    @Override
    public void reserveTicket(Integer showId, Ticket ticket) {

    }

    @Override
    public void reserveTickets(Integer showId, List<Ticket> tickets) {

    }

    @Override
    public void unReserveTicket(Integer showId, Integer ticketId) {

    }

    @Override
    public void unReserveTickets(Integer showId, List<Integer> ticketsId) {

    }
}

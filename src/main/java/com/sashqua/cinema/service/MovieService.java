package com.sashqua.cinema.service;

import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.entity.Ticket;

import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 3/31/17.
 */
public interface MovieService {
    List<Movie> findAll(Integer hallId);
    List<Movie> getByDate(Date date);
    void addMovie(Movie movie);
    void deleteMovie(Integer id);
    void getMovie(Integer id);
    void editMovie(Integer id);
    void addMoiveShowing(MovieShowing movieShowing);
    void deleteMoiveShowing(Integer showId);
    void reserveTicket(Integer showId, Ticket ticket);
    void reserveTickets(Integer showId, List<Ticket> tickets);
    void unReserveTicket(Integer showId, Integer ticketId);
    void unReserveTickets(Integer showId, List<Integer> ticketsId);

}

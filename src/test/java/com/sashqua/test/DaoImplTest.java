package com.sashqua.test;

import com.sashqua.cinema.dao.impl.BookingDAOImpl;
import com.sashqua.cinema.dao.impl.MovieDAOImpl;
import com.sashqua.cinema.dao.impl.MovieShowingDAOImpl;
import com.sashqua.cinema.entity.Booking;
import com.sashqua.cinema.entity.Movie;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.entity.Ticket;
import com.sashqua.cinema.service.BookingService;
import com.sashqua.cinema.service.impl.BookingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.sashqua.cinema.service.")
public class DaoImplTest {
    @Test
    public void checkMovieShowingDao() {
        MovieShowingDAOImpl movieShowingDAO = new MovieShowingDAOImpl();
        List<MovieShowing> movieShowings = new ArrayList<>();
        movieShowings.addAll(movieShowingDAO.findAll());
        MovieShowing movieShowing = new MovieShowing();
        movieShowing = movieShowingDAO.getMovieShowing(3);
        System.out.println(movieShowings);
    }

    @Test
    public void checkMovie() {
        MovieDAOImpl movieDAO = new MovieDAOImpl();
        List<Movie> movieList = new ArrayList<>();
        movieList.addAll(movieDAO.findAll());
        System.out.println(movieList);
    }

    @Test
    public void chetBookign() {
        BookingDAOImpl bookingDAO = new BookingDAOImpl();
        Booking booking = new Booking();
        booking = bookingDAO.getBooking(1);
        System.out.println(booking);
    }


//    @Autowired
//    public BookingService bookingService;


    @Test
    public void setBookingTest() {
        BookingDAOImpl bookingDAO = new BookingDAOImpl();
        Booking booking = new Booking();
        MovieShowing movieShowing = new MovieShowing();
        movieShowing.setId(1);
        MovieShowingDAOImpl movieShowingDAO = new MovieShowingDAOImpl();
        movieShowingDAO.addMovieShowing(movieShowing);
        List<Ticket> tickets= new ArrayList<>();
        Ticket ticket = new Ticket();
        ticket.setId(23);
        ticket.setRow(1);
        ticket.setSeat(2);
        tickets.add(ticket);
        booking.setMovieShowing(movieShowing);
        booking.setTickets(tickets);
        bookingDAO.addBooking(booking);
    }

    @Test
    public void deleteBookingTest() {
        BookingDAOImpl bookingDAO = new BookingDAOImpl();
//        bookingDAO.deleteBooking(2);
     Booking booking = new Booking();
        booking = bookingDAO.getBooking(8);
        System.out.println(booking);

    }

}

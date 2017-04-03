package com.sashqua.cinema.dao.impl;

import com.sashqua.cinema.dao.BookingDAO;
import com.sashqua.cinema.entity.Booking;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@Repository
public class BookingDAOImpl implements BookingDAO {

    private Properties props;
    private OutputStreamWriter outputStream;
    private MovieShowingDAOImpl movieShowingDAO;

    public BookingDAOImpl() {
        try {
            props = new Properties();
            movieShowingDAO = new MovieShowingDAOImpl();
            FileInputStream in = new FileInputStream("src/main/resources/Booking.dat");
            props.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addBooking(Booking booking) {
        try {
            outputStream = new OutputStreamWriter(new FileOutputStream("src/main/resources/Booking.dat"), "UTF-8");
            int num = Integer.valueOf(props.getProperty("booking.num"));
            props.setProperty("booking.num", String.valueOf(num+1));

            props.setProperty("booking.showing."+(num+1), String.valueOf(booking.getMovieShowing().getId()));
            for (int i = 0; i < booking.getTickets().size(); ++i) {
                props.setProperty("booking.ticket." + (i+1) + "." + (num+1), String.valueOf(booking.getTickets().get(i).getId()));
            }
            props.store(outputStream, "");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBooking(Integer id) {

    }

    @Override
    public Booking getBooking(Integer id) {
        Booking booking = new Booking();
        MovieShowing movieShowing = new MovieShowing();
        movieShowing = movieShowingDAO.getMovieShowing(Integer.parseInt(props.getProperty("booking.showing." + id)));
        if (movieShowing != null) {
            booking.setMovieShowing(movieShowing);
            List<Ticket> ticketList = new ArrayList<>();
            for (int i = 1; i <= 200; ++i) {
                Ticket ticket = new Ticket();
                String prop = props.getProperty("booking.ticket." + i + "." + id);
                if (prop != null) {
                    ticket = movieShowing.getAllTickets().get(Integer.parseInt(prop));
                    ticketList.add(ticket);
                }
                else break;
            }
            booking.setTickets(ticketList);
            booking.setId(id);
        }
        return booking;
    }
}

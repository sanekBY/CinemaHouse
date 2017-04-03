package com.sashqua.cinema.service.impl;

import com.sashqua.cinema.dao.BookingDAO;
import com.sashqua.cinema.dao.MovieShowingDAO;
import com.sashqua.cinema.entity.Booking;
import com.sashqua.cinema.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingDAO bookingDAO;

    @Override
    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    @Override
    public void deleteBooking(Integer id) {

    }

    @Override
    public Booking getBooking(Integer id) {
        return bookingDAO.getBooking(id);
    }
}

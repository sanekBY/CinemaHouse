package com.sashqua.cinema.service;

import com.sashqua.cinema.entity.Booking;

/**
 * CinemaHouse project
 *
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
public interface BookingService {
    public void addBooking(Booking booking);
    public void deleteBooking(Integer id);
    public Booking getBooking(Integer id);
}

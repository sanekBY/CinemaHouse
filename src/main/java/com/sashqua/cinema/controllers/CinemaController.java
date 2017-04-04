package com.sashqua.cinema.controllers;

import com.sashqua.cinema.entity.Booking;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.service.BookingService;
import com.sashqua.cinema.service.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * CinemaHouse project
 * @Version 1.0
 * Created by Alexandr Shalukho.
 */
@RestController
public class CinemaController {

    @Autowired
    private final MovieShowingService movieShowingService;
    @Autowired
    private final BookingService bookingService;

    @Inject
    public CinemaController(MovieShowingService movieShowingService, BookingService bookingService) {
        this.movieShowingService = movieShowingService;
        this.bookingService = bookingService;
    }
    /**
     * Get showing
     */
    @RequestMapping(value = "/api/showing/{id}", method = {RequestMethod.GET})
    public MovieShowing getShowing(@PathVariable("id") Integer id) {
        return movieShowingService.getMovieShowing(id);
    }
    /**
     * Get all film showings
     */
    @RequestMapping(value = "/api/showing-list" ,  method = {RequestMethod.GET})
    public List<MovieShowing> getShowingList() {
        return movieShowingService.findAll();
    }
    /**
     * Get booking info
     */
    @RequestMapping(value = "/api/booking/{id}", method = {RequestMethod.GET})
    public Booking getBooking(@PathVariable("id") Integer id) {
        return bookingService.getBooking(id);
    }
    /**
     * Booking tickets
     */
    @RequestMapping(value = "/api/booking}", method = RequestMethod.POST)
    public void addBooking (@RequestBody @Valid final Booking booking) {
        bookingService.addBooking(booking);
    }
    /**
     * Delete tickets Booking
     */
    @RequestMapping(value = "/api/booking/{id}", method = {RequestMethod.DELETE})
    public void deleteBooking(@PathVariable("id") Integer id) {
        bookingService.deleteBooking(id);
    }


}

package com.sashqua.cinema.controllers;

import com.sashqua.cinema.entity.Booking;
import com.sashqua.cinema.entity.MovieShowing;
import com.sashqua.cinema.service.BookingService;
import com.sashqua.cinema.service.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
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


    @RequestMapping(value = "/api/showing/{id}", method = {RequestMethod.GET})
    public MovieShowing getShowing(@PathVariable("id") Integer id) {
        return movieShowingService.getMovieShowing(id);
    }

    @RequestMapping(value = "/api/showing-list" ,  method = {RequestMethod.GET})
    public List<MovieShowing> getShowingList() {
        return movieShowingService.findAll();
    }

    @RequestMapping(value = "/api/booking/{id}", method = {RequestMethod.GET})
    public Booking getBooking(@PathVariable("id") Integer id) {
        return bookingService.getBooking(id);
    }


}

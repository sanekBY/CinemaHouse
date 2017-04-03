package com.sashqua.cinema.controllers;

import com.sashqua.cinema.entity.MovieShowing;
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

    @Inject
    public CinemaController(MovieShowingService movieShowingService) {
        this.movieShowingService = movieShowingService;
    }


    @RequestMapping(value = "/api/showing/{id}", method = {RequestMethod.GET})
    public MovieShowing getVoter(@PathVariable("id") Integer id) {
        return movieShowingService.getMovieShowing(id);
    }

    @RequestMapping(value = "/api/showing-list" ,  method = {RequestMethod.GET})
    public List<MovieShowing> getShowingList() {
        return movieShowingService.findAll();
    }


}

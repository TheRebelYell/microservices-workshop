package com.example.movie_info_service.service;

import com.example.movie_info_service.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieService {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Name for ID " + movieId);
    }
}

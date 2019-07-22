package com.example.ratings_data_service.service;

import com.example.ratings_data_service.model.Rating;
import com.example.ratings_data_service.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingService {

    @GetMapping("/movie/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}

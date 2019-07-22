package com.example.ratings_data_service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("abc", 3),
                new Rating("xyz", 5)
        ));
    }
}

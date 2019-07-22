package com.example.movie_catalog_service.service;

import com.example.movie_catalog_service.model.CatalogItem;
import com.example.movie_catalog_service.model.Movie;
import com.example.movie_catalog_service.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/rating/user/" + userId, UserRating.class);


        return userRating.getRatings().stream()
                .map(r -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + r.getMovieId(), Movie.class);
//                    Movie movie = webClientBuilder.build().get().uri("http://movie-info-service/movie/"+ r.getMovieId())
//                    .retrieve().bodyToMono(Movie.class).block();
                    return new CatalogItem(movie.getName(), "Description", r.getRating());
                })
                .collect(Collectors.toList());
    }
}

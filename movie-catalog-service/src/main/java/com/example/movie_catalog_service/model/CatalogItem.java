package com.example.movie_catalog_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CatalogItem {

    private String name;
    private String description;
    private int rating;
}

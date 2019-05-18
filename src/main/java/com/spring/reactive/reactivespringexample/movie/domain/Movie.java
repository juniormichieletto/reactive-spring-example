package com.spring.reactive.reactivespringexample.movie.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    private String id;

    private String title;

    private Movie() {}

    public Movie(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            '}';
    }
}

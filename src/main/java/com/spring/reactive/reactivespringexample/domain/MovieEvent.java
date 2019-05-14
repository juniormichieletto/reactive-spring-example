package com.spring.reactive.reactivespringexample.domain;

import java.util.Date;

public class MovieEvent {

    private String movieId;
    private Date date;

    private MovieEvent() {
    }

    public MovieEvent(String movieId, Date date) {
        this.movieId = movieId;
        this.date = date;
    }

    public String getMovieId() {
        return movieId;
    }

    public Date getDate() {
        return date;
    }
}

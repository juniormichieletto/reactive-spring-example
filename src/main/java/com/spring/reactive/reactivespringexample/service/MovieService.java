package com.spring.reactive.reactivespringexample.service;

import com.spring.reactive.reactivespringexample.domain.Movie;
import com.spring.reactive.reactivespringexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();
}

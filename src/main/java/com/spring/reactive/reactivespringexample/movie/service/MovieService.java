package com.spring.reactive.reactivespringexample.movie.service;

import com.spring.reactive.reactivespringexample.movie.domain.Movie;
import com.spring.reactive.reactivespringexample.movie.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();
}

package com.spring.reactive.reactivespringexample.movie.repository;

import com.spring.reactive.reactivespringexample.movie.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}

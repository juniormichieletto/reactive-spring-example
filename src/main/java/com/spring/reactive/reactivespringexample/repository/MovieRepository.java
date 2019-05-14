package com.spring.reactive.reactivespringexample.repository;

import com.spring.reactive.reactivespringexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}

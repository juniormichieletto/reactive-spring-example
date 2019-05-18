package com.spring.reactive.reactivespringexample.movie.controller;

import com.spring.reactive.reactivespringexample.movie.domain.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
//@WebFluxTest
public class MovieControllerIT {

    @Autowired
    private WebTestClient webClient;

    private static String BASE_PATH = "/api/v1/movies";

    @Test
    public void getAllMovies() {

        webClient.get()
            .uri(BASE_PATH)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Movie.class)
            .hasSize(7);
    }

    @Test
    public void getAllMovies_thanGetTheFirstMovieById() {

        Optional<Movie> firstMovie = webClient.get()
            .uri(BASE_PATH)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Movie.class)
            .hasSize(7)
            .returnResult()
            .getResponseBody()
            .stream()
            .findFirst();

        firstMovie.ifPresent(movie ->
            webClient.get()
                .uri(BASE_PATH + "/{id}", movie.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Movie.class)
            );

    }
}

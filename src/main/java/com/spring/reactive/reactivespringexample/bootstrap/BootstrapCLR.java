package com.spring.reactive.reactivespringexample.bootstrap;

import com.spring.reactive.reactivespringexample.domain.Movie;
import com.spring.reactive.reactivespringexample.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository
                .deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas",
                                "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                                "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                                .map(title -> new Movie(UUID.randomUUID().toString(), title))
                                .flatMap(movieRepository::save)
                )
                .subscribe(
                        null,
                        null,
                        () -> movieRepository.findAll().subscribe(System.out::println)
                );
    }
}

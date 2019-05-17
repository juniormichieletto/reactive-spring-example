package com.spring.reactive.reactivespringexample.service;

import com.spring.reactive.reactivespringexample.domain.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration period);
}

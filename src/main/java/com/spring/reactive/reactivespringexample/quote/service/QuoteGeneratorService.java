package com.spring.reactive.reactivespringexample.quote.service;

import com.spring.reactive.reactivespringexample.quote.domain.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration period);
}

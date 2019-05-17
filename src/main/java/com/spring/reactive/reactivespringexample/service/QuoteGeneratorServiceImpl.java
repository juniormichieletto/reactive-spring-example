package com.spring.reactive.reactivespringexample.service;

import com.spring.reactive.reactivespringexample.domain.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class QuoteGeneratorServiceImpl implements QuoteGeneratorService {

    @Override
    public Flux<Quote> fetchQuoteStream(Duration period) {
        return null;
    }
}

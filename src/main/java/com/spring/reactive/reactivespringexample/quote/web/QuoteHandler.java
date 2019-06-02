package com.spring.reactive.reactivespringexample.quote.web;

import com.spring.reactive.reactivespringexample.quote.domain.Quote;
import com.spring.reactive.reactivespringexample.quote.service.QuoteGeneratorService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QuoteHandler {

    private final QuoteGeneratorService quoteGeneratorService;

    public QuoteHandler(QuoteGeneratorService quoteGeneratorService) {
        this.quoteGeneratorService = quoteGeneratorService;
    }

    public Mono<ServerResponse> fetchQuotes(ServerRequest request) {
        final int size = Integer.parseInt(request.queryParam("size").orElse("10"));

        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100))
                .take(size), Quote.class);
    }
}

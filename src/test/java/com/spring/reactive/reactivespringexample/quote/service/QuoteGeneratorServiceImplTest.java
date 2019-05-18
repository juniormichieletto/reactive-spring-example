package com.spring.reactive.reactivespringexample.quote.service;

import com.spring.reactive.reactivespringexample.quote.domain.Quote;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class QuoteGeneratorServiceImplTest {

    private QuoteGeneratorService quoteGeneratorService = new QuoteGeneratorServiceImpl();

    @DisplayName("FetchQuoteStream Test")
    @Test
    public void fetchQuoteStream() throws InterruptedException {
        Flux<Quote> quoteFlux =
            quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(1L));

        quoteFlux.take(22000)
            .subscribe(System.out::println);

    }

    @Test
    public void fetchQuoteStreamCountDown() throws Exception {

        Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100L));

        Consumer<Quote> printlnConsumer = System.out::println;

        Consumer<Throwable> errorHandler = e -> System.out.println("Some Error Occurred");

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable countDownExecutor = () -> countDownLatch.countDown();

        quoteFlux.take(30)
            .subscribe(printlnConsumer, errorHandler, countDownExecutor);

        countDownLatch.await();
    }
}

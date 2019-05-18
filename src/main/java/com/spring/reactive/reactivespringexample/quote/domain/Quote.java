package com.spring.reactive.reactivespringexample.quote.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;

public class Quote {

    private static final MathContext MATH_CONTEXT = new MathContext(2);

    private String ticker;
    private BigDecimal price;
    private Instant instant;

    public Quote(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    public Quote(String ticker, Double price) {
        this.ticker = ticker;
        this.price = new BigDecimal(price, MATH_CONTEXT);
    }

    public String getTicker() {
        return ticker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getInstant() {
        return instant;
    }

    public Quote setInstant(Instant instant) {
        this.instant = instant;
        return this;
    }

    @Override
    public String toString() {
        return "Quote{" +
            "ticker='" + ticker + '\'' +
            ", price=" + price +
            ", instant=" + instant +
            '}';
    }
}

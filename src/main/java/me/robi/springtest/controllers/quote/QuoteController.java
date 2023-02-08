package me.robi.springtest.controllers.quote;

import me.robi.springtest.exceptions.ElementNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequestMapping("/quotes")
@RestController
public class QuoteController {
    public static final List<Quote> QUOTES = new ArrayList<>();
    static {
        QUOTES.add(new Quote("Author1", "Quote1"));
        QUOTES.add(new Quote("Author2", "Quote2"));
        QUOTES.add(new Quote("Author3", "Quote3"));
        QUOTES.add(new Quote("Author4", "Quote4"));
        QUOTES.add(new Quote("Author5", "Quote5"));
        QUOTES.add(new Quote("Author6", "Quote6"));
        QUOTES.add(new Quote("Author7", "Quote7"));
    }

    @GetMapping("/{id}")
    public Quote randomQuote(@PathVariable(value = "id") int id) {
        if(id < 0 || id >= QUOTES.size()) {
            throw new ElementNotFoundException("Quote Index Out of Bounds D:");
        }
        return QUOTES.get(id);
    }

    @GetMapping("/random")
    public Quote randomQuote() {
        return QUOTES.get(ThreadLocalRandom.current().nextInt(QUOTES.size()));
    }

    @GetMapping
    public List<Quote> allQuotes() {
        return QUOTES;
    }
}


package com.example.randomquote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class RandomQuoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomQuoteApplication.class, args);
    }
}

@RestController
class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random-quote")
    public QuoteDTO getRandomQuote() {
        return quoteService.getRandomQuote();
    }
}

interface QuoteService {
    QuoteDTO getRandomQuote();
}

@Service
class QuoteServiceImpl implements QuoteService {

    private final List<Quote> quotes = List.of(
            new Quote(1, "Il successo è la somma di piccoli sforzi ripetuti giorno dopo giorno.", "Robert Collier"),
            new Quote(2, "La vita è quello che ti succede mentre sei impegnato a fare altri progetti.", "John Lennon"),
            new Quote(3, "Sii il cambiamento che vuoi vedere nel mondo.", "Mahatma Gandhi")
    );

    @Override
    public QuoteDTO getRandomQuote() {
        Random random = new Random();
        Quote quote = quotes.get(random.nextInt(quotes.size()));
        return new QuoteDTO(quote.getText(), quote.getAuthor());
    }
}

class Quote {
    private final int id;
    private final String text;
    private final String author;

    public Quote(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}

class QuoteDTO {
    private final String text;
    private final String author;

    public QuoteDTO(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}

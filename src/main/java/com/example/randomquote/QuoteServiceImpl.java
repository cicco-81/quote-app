package com.example.randomquote;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

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

package com.example.randomquote;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
class QuoteServiceImpl implements QuoteService {

    private final List<Quote> quotes = List.of(
            new Quote(1, "Il successo e' la somma di piccoli sforzi ripetuti giorno dopo giorno.", "Robert Collier"),
            new Quote(2, "La vita e' quello che ti succede mentre sei impegnato a fare altri progetti.", "John Lennon"),
            new Quote(3, "Sii il cambiamento che vuoi vedere nel mondo.", "Mahatma Gandhi"),
            new Quote(4, "La realtà non è cio' che ci accade ma cio' che noi facciamo con quello che ci accade.", "Aldous Huxley"),
            new Quote(5, "Impara a scrivere le tue ferite sulla sabbia e a incidere le tue gioie nella pietra.", "Lao Tzu"),
            new Quote(6, "Solo chi rischia di andare troppo lontano avra' la possibilità di scoprire quanto lontano puo' andare.", "T.S. Eliot"),
            new Quote(7, "La vita e' piena di problemi …. Se riuscita a cambiare i problemi in domande….la vita cambia", "Nikasaghi"),
            new Quote(8, "Non temete i momenti difficili, e' da li che arrivano le cose migliori.", "Rita Levi-Montalcini"),
            new Quote(9, "La vita e' come una bicicletta, per mantenere l'equilibrio devi muoverti.", "Albert Einstein"),
            new Quote(10, "La vita e' un' opportunita', coglila.", "Madre Teresa di Calcutta"),
            new Quote(11, "La vita puo' essere vissuta solo guardando avanti, compresa guardando indietro.", "Soren Kierkegaard"),
            new Quote(12, "Ogni cosa conduce a un' altra cosa, che conduce a un' altra cosa ….. se ti concentri sul fare la piu' piccola, poi la successiva e cosi via…..ti troverai a giungere a fare le grandi cose avendo fatto solo le piccole.", "Weakland"),
            new Quote(13, "Le idee si trasformano in noi, trionfano sulle resistenze che inizialmente opponiamo loro.", "Marcel Proust"),
            new Quote(14, "Il vero viaggio di scoperta non e' vedere nuovi mondi ma cambiare occhi.", "Marcel Proust"),
            new Quote(15, "Gli uomini sono i principali artefici delle proprie disgrazie.", "Pitagora")
    );

    @Override
    public QuoteDTO getRandomQuote() {
        Random random = new Random();
        Quote quote = quotes.get(random.nextInt(quotes.size()));
        return new QuoteDTO(quote.getText(), quote.getAuthor());
    }
}

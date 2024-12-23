package com.example.randomquote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // inserisci un metodo che restituisca un QuoteDTO con il testo "Hello, World!" e l'autore "Anonymous"      
    @GetMapping("/hello-world") 
    public QuoteDTO getHelloWorld() {
        return new QuoteDTO("Hello, World!", "Anonymous");
    }
    
}

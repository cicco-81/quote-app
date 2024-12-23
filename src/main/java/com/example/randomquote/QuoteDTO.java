package com.example.randomquote;

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

package br.com.dojo.inu.domain;

/**
 * Created by rachidcalazans on 10/8/16.
 */
public class Card {

    private String identifier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return identifier != null ? identifier.equals(card.identifier) : card.identifier == null;

    }

    @Override
    public int hashCode() {
        return identifier != null ? identifier.hashCode() : 0;
    }
}

package br.com.dojo.inu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rachidcalazans on 10/8/16.
 */
public class Player {
    public List<Card> cards = new ArrayList<Card>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cardsForHand) {
      this.cards = cardsForHand;
    }
}

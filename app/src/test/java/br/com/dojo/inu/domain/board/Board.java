package br.com.dojo.inu.domain.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by rachidcalazans on 10/8/16.
 */
public class Board {

    public List shuffleCards(List unShuffleCards) {
        List cards = sortCards(unShuffleCards);

//        if (cards.equals(unShuffleCards))
//            shuffleCards(cards);

        return cards;
    }

    private List sortCards(List unShuffleCards) {
        long seed         = System.nanoTime();
        List shuffleCards = new ArrayList<>();

        shuffleCards.addAll(unShuffleCards);
        Collections.copy(shuffleCards, unShuffleCards);

        Collections.shuffle(shuffleCards, new Random(seed));

        return shuffleCards;
    }

}

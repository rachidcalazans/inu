package br.com.dojo.inu.domain.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.dojo.inu.domain.Player;

/**
 * Created by rachidcalazans on 10/8/16.
 */
public class Board {

    int INITIAL_CARD_NUMBER = 7;

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

    public void deliverInitialCards(List<Player> players, List cards) {


        for(Player player : players) {
            List cardsForHand = getPlayerHand(cards);
            player.setCards(cardsForHand);
        }


    }

    private List getPlayerHand(List cards) {

        List playerHand = cards.subList(0, INITIAL_CARD_NUMBER-1);

        return playerHand;
    }
}

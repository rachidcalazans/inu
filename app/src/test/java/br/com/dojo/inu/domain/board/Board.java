package br.com.dojo.inu.domain.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.dojo.inu.domain.Card;
import br.com.dojo.inu.domain.Player;

/**
 * Created by rachidcalazans on 10/8/16.
 */
public class Board {

    int INITIAL_CARD_NUMBER = 7;

    public List<Card> shuffleCards(List<Card> unShuffleCards) {
        List<Card> cards = sortCards(unShuffleCards);

//        if (cards.equals(unShuffleCards))
//            shuffleCards(cards);

        return cards;
    }

    private List<Card> sortCards(List<Card> unShuffleCards) {
        long seed         = System.nanoTime();
        List<Card> shuffleCards = new ArrayList<Card>();

        shuffleCards.addAll(unShuffleCards);
        Collections.copy(shuffleCards, unShuffleCards);

        Collections.shuffle(shuffleCards, new Random(seed));

        return shuffleCards;
    }

    public void deliverInitialCards(List<Player> players, List<Card> cards) {


        for(Player player : players) {
            List<Card> cardsForHand = getPlayerHand(cards);
            player.setCards(cardsForHand);
        }


    }

    private List<Card> getPlayerHand(List<Card> cards) {

        List<Card> playerHand = new ArrayList<Card>( cards.subList(0, INITIAL_CARD_NUMBER));
//        for(String card : playerHand) {
//            cards.remove(card);
//        }
        cards.removeAll(playerHand);
        return playerHand;
    }
}

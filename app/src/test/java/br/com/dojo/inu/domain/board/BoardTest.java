package br.com.dojo.inu.domain.board;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.dojo.inu.domain.Card;
import br.com.dojo.inu.domain.Player;

/**
 * Created by rachidcalazans on 10/8/16.
 */

@RunWith(Enclosed.class)
public class BoardTest {

    public static abstract class Given_a_Board {
        Board board;

        @Before
        public void givenABoard(){
            board = new Board();
        }
    }

    public static abstract class Describe_shuffle_cards extends Given_a_Board {
        List<Card> resultCards;
        List<Card> unShuffleCards;

        @Before
        public void before() {
            setUnshuffleCards();
            resultCards = board.shuffleCards(unShuffleCards);
        }

        void setUnshuffleCards() {
            unShuffleCards = null;
        }
    }

    public static class When_receive_a_list_of_cards extends Describe_shuffle_cards {
        @Override
        void setUnshuffleCards() {
            unShuffleCards = new ArrayList<Card>(Arrays.asList(new Card("Card1"), new Card("Card2"))) ;
        }

        @Test
        public void It_should_suffle_the_order() {
            Assert.assertNotSame( unShuffleCards, resultCards );
        }
    }

    public abstract static class Given_two_players extends Given_a_Board {

        List<Player> players = new ArrayList<Player>();

        @Before
        public void givenTwoPlayers(){
            Player playerOne = new Player();
            Player playerTwo = new Player();

            players.add(playerOne);
            players.add(playerTwo);

        }
    }

    public static class Describe_deliverInitialCards extends Given_two_players {

        private int expectedNumberOfHandCards = 7;
        private int expectedFinalNumberOfCards = 40;
        private List<Card> cards = new ArrayList<Card>();

        @Before
        public void deliver_initial_cards(){
            for(int i = 1; i <= 54; ++i) {
                String identifier = "card" +i;
                Card card = new Card( identifier );
                cards.add(card);
            }

            board.deliverInitialCards(players, cards);
        }

        @Test
        public void It_player_should_has_seven_cards() {
            Player playerOne = players.get(0);
            int resultNumberOfCards = Integer.valueOf(playerOne.getCards().size());
            Assert.assertEquals(expectedNumberOfHandCards, resultNumberOfCards);
        }

        @Test
        public void It_number_of_cards_sould_be_reduced_based_on_the_number_of_players() {
            Assert.assertEquals(expectedFinalNumberOfCards, cards.size());
        }
    }

}

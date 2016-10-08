package br.com.dojo.inu.domain.board;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List resultCards;
        List unShuffleCards;

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
            unShuffleCards = new ArrayList<>(Arrays.asList("Card1","Card2","Card3")) ;
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

        private int expectedNumberOfCards = 7;
        private List cards;

        @Before
        public void deliver_initial_cards(){
            board.deliverInitialCards(players, cards);
        }

        @Test
        public void It_player_should_has_seven_cards() {
            Player playerOne = players.get(0);
            int resultNumberOfCards = Integer.valueOf(playerOne.getCards().size());
            Assert.assertEquals(expectedNumberOfCards, resultNumberOfCards);
        }
    }

}

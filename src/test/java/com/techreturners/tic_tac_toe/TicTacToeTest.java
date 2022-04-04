package com.techreturners.tic_tac_toe;

import com.techreturners.tic_tac_toe.app.TicTacToe;
import com.techreturners.tic_tac_toe.model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private static final int GRID_SIZE = 9;
    private static final String SUCCESSFUL_TURN_MESSAGE = "Player %s played their turn in position %s.";
    private static final String GRID_SPACED_FILLED_MESSAGE = "That grid space is already filled.";
    private static final String GAME_OVER_NO_WINNER_MESSAGE = " The Game is over. No-one won.";
    private TicTacToe game;

    @BeforeEach
    public void setUp(){
        game = new TicTacToe();
    }

    @Test
    public void testEmptyGridFirstMove() {
        int gridPosition = 1;
        assertEquals(String.format(SUCCESSFUL_TURN_MESSAGE, Tile.X, gridPosition), game.play(gridPosition));
    }


    @Test
    public void testEmptyGridSecondMove() {
        int gridPosition = 1;

        game.play(2);
        assertEquals(String.format(SUCCESSFUL_TURN_MESSAGE, Tile.O, gridPosition), game.play(gridPosition));
    }

    @Test
    public void testEmptyGridEighthMove(){
        int gridPosition = 1;
        for(;gridPosition < GRID_SIZE-1; gridPosition ++){
            game.play(gridPosition);
        }
        assertEquals(String.format(SUCCESSFUL_TURN_MESSAGE, Tile.O, gridPosition), game.play(gridPosition));
    }

    @Test
    public void testPlacingTileInFilledGridSpace(){
        int gridPosition = 1;
        game.play(gridPosition);
        assertEquals(GRID_SPACED_FILLED_MESSAGE, game.play(gridPosition));
    }

    @Test
    public void testAllSpacesFilledAndNoWinner(){
        int[] moves = {1,2,4,7,5,6,8,9,3};
        int lastMove = moves[moves.length-1];
        String expectedFinalMessage = String.format(SUCCESSFUL_TURN_MESSAGE, Tile.X, lastMove) + GAME_OVER_NO_WINNER_MESSAGE;
        runTheGame(moves, expectedFinalMessage);
    }

    private void runTheGame(int[] moves, String expectedFinalMessage) {;

        int i = 0;
        for (; i < moves.length-1; i++) {
            game.play(moves[i]);
        }
        assertEquals(expectedFinalMessage, game.play(moves[i]));
    }
}
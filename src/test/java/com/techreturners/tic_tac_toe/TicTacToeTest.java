package com.techreturners.tic_tac_toe;

import com.techreturners.tic_tac_toe.app.TicTacToe;
import com.techreturners.tic_tac_toe.model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private static final int GRID_SIZE = 9;
    private static final String SUCCESSFUL_TURN_MESSAGE = "Player %s played their turn in position %s";
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
    public void testEmptyGridNinthMove(){
        int gridPosition = 1;
        for(;gridPosition < GRID_SIZE; gridPosition ++){
            game.play(gridPosition);
        }
        assertEquals(String.format(SUCCESSFUL_TURN_MESSAGE, Tile.X, gridPosition), game.play(gridPosition));
    }


}
package com.techreturners.tic_tac_toe;

import com.techreturners.tic_tac_toe.app.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    TicTacToe game;

    @BeforeEach
    public void setUp(){
        game = new TicTacToe();
    }

    @Test
    public void testEmptyGridFirstMove() {
        int gridPosition = 1;
        assertEquals(String.format("Player X played their turn in position %s", gridPosition), game.play(gridPosition));
    }


    @Test
    public void testEmptyGridSecondMove() {
        int gridPosition = 1;

        game.play(2);
        assertEquals(String.format("Player O played their turn in position %s", gridPosition), game.play(gridPosition));
    }


}
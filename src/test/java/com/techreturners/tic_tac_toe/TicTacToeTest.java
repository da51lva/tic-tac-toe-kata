package com.techreturners.tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTest {

    @Test
    public void testEmptyGridFirstMove() {
        TicTacToe game = new TicTacToe();
        int gridPosition = 1;
        assertEquals(String.format("Player X played their turn in position %s", gridPosition), game.play(gridPosition));
    }
    
}
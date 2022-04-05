package com.techreturners.tic_tac_toe.app;

import com.techreturners.tic_tac_toe.model.Tile;
import com.techreturners.tic_tac_toe.model.WinningGridSpaces;

public class TicTacToe {

    private static final int GRID_SIZE = 9;
    private static final String SUCCESSFUL_TURN_MESSAGE = "Player %s played their turn in position %s.";
    private static final String GRID_SPACED_FILLED_MESSAGE = "That grid space is already filled.";
    private static final String GAME_OVER_NO_WINNER_MESSAGE = " The Game is over. No-one won.";
    private static final String GAME_OVER_WINNER_MESSAGE = " The Game is over. %s won.";

    private Tile tile;
    private Tile[] grid = new Tile[GRID_SIZE];

    private int noOfTurns = 0;

    public TicTacToe(){
        tile = Tile.X;
    }

    /**
     * Plays a move on a Tic Tac Toe grid, Player X starts first and then alternates every turn. The grid positions are:
     *
     * [1][2][3]
     * [4][5][6]
     * [7][8][9]
     *
     * @param position the grid position to play
     * @return a String stating whether the move was successful and the state of the game
     */
    public String play(int position){
        int gridIndex = position - 1;
        if (grid[gridIndex] != null) return GRID_SPACED_FILLED_MESSAGE;

        //play the turn
        grid[gridIndex] = tile;
        String message = String.format(SUCCESSFUL_TURN_MESSAGE, tile, position);
        noOfTurns++;

        if(playerWon())
            message = message + String.format(GAME_OVER_WINNER_MESSAGE, tile);
        else if(noOfTurns == GRID_SIZE)
            message = message + GAME_OVER_NO_WINNER_MESSAGE;
        else
            tile = tile == Tile.X ? Tile.O : Tile.X; //invert the turn;

        return message;
    }

    private boolean playerWon() {
        if(grid[0] != null && grid[0] == grid[1] && grid[0] == grid[2])
            return true;
        else if(grid[3] != null && grid[3] == grid[4] && grid[3] == grid[5])
            return true;
        else
            return false;
    }

}

package com.techreturners.tic_tac_toe.app;

import com.techreturners.tic_tac_toe.model.Tile;

public class TicTacToe {

    private static final int GRID_SIZE = 9;
    private static final String SUCCESSFUL_TURN_MESSAGE = "Player %s played their turn in position %s";
    private static final String GRID_SPACED_FILLED_MESSAGE = "That grid space is already filled";

    private Tile tile;
    private Tile[] grid = new Tile[GRID_SIZE];

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

        grid[gridIndex] = tile;
        String message = String.format(SUCCESSFUL_TURN_MESSAGE, tile, position);
        tile = tile == Tile.X ? Tile.O : Tile.X; //invert the turn;

        return message;
    }



}

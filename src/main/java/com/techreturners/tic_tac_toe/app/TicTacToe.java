package com.techreturners.tic_tac_toe.app;

import com.techreturners.tic_tac_toe.model.Tile;

public class TicTacToe {


    private Tile tile;

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
        String message = String.format("Player %s played their turn in position %s", tile, position);
        tile = tile == Tile.X ? Tile.O : Tile.X; //invert the turn;
        return message;
    }


}

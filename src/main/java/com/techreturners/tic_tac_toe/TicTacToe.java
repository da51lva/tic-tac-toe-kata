package com.techreturners.tic_tac_toe;

public class TicTacToe {

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
        return String.format("Player X played their turn in position %s", position);
    }


}

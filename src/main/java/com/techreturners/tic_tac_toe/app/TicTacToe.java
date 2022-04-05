package com.techreturners.tic_tac_toe.app;

import com.techreturners.tic_tac_toe.model.TicTacToeBoard;
import com.techreturners.tic_tac_toe.model.Tile;

public class TicTacToe {

    private static final String SUCCESSFUL_TURN_MESSAGE = "Player %s played their turn in position %s.";
    private static final String GRID_SPACED_FILLED_MESSAGE = "That grid space is already filled.";
    private static final String GAME_OVER_NO_WINNER_MESSAGE = " The Game is over. No-one won.";
    private static final String GAME_OVER_WINNER_MESSAGE = " The Game is over. %s won.";

    private Tile tile;
    private TicTacToeBoard board;

    public TicTacToe() {
        tile = Tile.X;
        board = new TicTacToeBoard();
    }

    /**
     * Plays a move on a Tic Tac Toe grid, Player X starts first and then alternates every turn. The grid positions are:
     * <p>
     * [1][2][3]
     * [4][5][6]
     * [7][8][9]
     *
     * @param position the grid position to play
     * @return a String stating whether the move was successful and the state of the game
     */
    public String play(int position) {

        if (!board.isPositionFree(position)) return GRID_SPACED_FILLED_MESSAGE;

        //play the turn
        board.playTile(tile,position);
        String message = String.format(SUCCESSFUL_TURN_MESSAGE, tile, position);


        Tile winner;
        if ((winner = board.hasPlayerWon()) != null)
            message = message + String.format(GAME_OVER_WINNER_MESSAGE, winner);
        else if (board.isFull())
            message = message + GAME_OVER_NO_WINNER_MESSAGE;
        else
            tile = tile == Tile.X ? Tile.O : Tile.X; //invert the turn;

        return message;
    }



}

package com.techreturners.tic_tac_toe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

    private static final int GRID_SIZE = 9;

    /*
     * Represents Tic Tac Toe board with indices as below:
     * [0][1][2]
     * [3][4][5]
     * [6][7][8]
     */
    private Tile[] board = new Tile[GRID_SIZE];
    private int positionsFilled = 0; //counts the number of board positions filled
    private int lastPosition = -1; //stored the last position played

    //a list of the containing the indices of the rows, columns and diagonal that constitutes a win
    private List<WinningThreeIndices> allWinningCombinations = new ArrayList<WinningThreeIndices>() {
        {
            add(new WinningThreeIndices(0, 1, 2)); //indices of first row
            add(new WinningThreeIndices(3, 4, 5)); //indices of second row
        }
    };


    public boolean isPositionFree(int position) {
        return board[position - 1] == null;
    }

    public void playTile(Tile tile, int position) {
        if (board[position - 1] != null)
            throw new IllegalArgumentException(String.format(
                    "Position %s on the TicTacToeBoard is already filled",
                    position
            ));
        board[position - 1] = tile;
        lastPosition = position;
        positionsFilled++;
    }

    public boolean isFull() {
        return positionsFilled == GRID_SIZE;
    }

    public Tile hasPlayerWon() {
        if (positionsFilled < 5) //at least 5 turns must be played
            return null;
        for (WinningThreeIndices wtp : allWinningCombinations) {
            if (wtp.contains(lastPosition - 1)) { //don't need to check combinations that don't contain last played position
                Tile winner = checkWinningThreeIndices(wtp);
                if (winner != null) {
                    return winner;
                }
            }
        }
        return null;
    }

    private Tile checkWinningThreeIndices(WinningThreeIndices wti) {
        Tile tileInFirstIndex = board[wti.getFirstIndex()];
        //check if all board indices of a winning combination contain all the same tiles
        if (tileInFirstIndex != null && tileInFirstIndex == board[wti.getSecondIndex()] && tileInFirstIndex == board[wti.getThirdIndex()])
            return tileInFirstIndex;
        else
            return null;
    }


}

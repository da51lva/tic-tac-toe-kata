package com.techreturners.tic_tac_toe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

    private static final int GRID_SIZE = 9;

    private Tile[] board = new Tile[GRID_SIZE];
    private int positionsFilled = 0;
    private int lastPosition = -1;

    private List<WinningThreeIndices> allWinningCombinations = new ArrayList<WinningThreeIndices>(){
        {
            add(new WinningThreeIndices(0,1,2));
            add(new WinningThreeIndices(3,4,5));
        }
    };


    public boolean isPositionFree(int position){
        return board[position-1] == null;
    }

    public void playTile(Tile tile, int position){
        if (board[position-1] != null)
            throw new IllegalArgumentException(String.format("Position %s on the TicTacToeBoard is already filled", position));
        board[position-1] =  tile;
        lastPosition = position;
        positionsFilled++;
    }

    public boolean isFull(){
        return positionsFilled == GRID_SIZE;
    }

    public Tile hasPlayerWon(){
        if(positionsFilled < 5) //at least 5 turns must be played
            return null;
        for(WinningThreeIndices wtp : allWinningCombinations){
            if (wtp.contains(lastPosition-1)){
                Tile winner = checkWinningThreeIndices(wtp);
                if(winner != null){
                    return winner;
                }
            }
        }
        return null;
    }

    private Tile checkWinningThreeIndices(WinningThreeIndices wti) {
        Tile tileInFirstIndex = board[wti.getFirstIndex()];
        if (tileInFirstIndex != null && tileInFirstIndex == board[wti.getSecondIndex()] && tileInFirstIndex == board[wti.getThirdIndex()])
            return tileInFirstIndex;
        else
            return null;
    }


}

package matt.thewizard.techreturners.tictactoe.model;

/**
 * Represents a Row, or Column or Diagonal on a Tic Tac Toe Board where if all the Tiles are the same constitutes a win
 * for a player
 */
public class WinningThreeIndices {

    private int[] wti = new int[3];

    protected WinningThreeIndices(int index1, int index2, int index3) {
        wti[0] = index1;
        wti[1] = index2;
        wti[2] = index3;
    }

    protected int getFirstIndex() {
        return wti[0];
    }

    protected int getSecondIndex() {
        return wti[1];
    }

    protected int getThirdIndex() {
        return wti[2];
    }

    protected boolean contains(int lastIndex) {
        for (int i : wti)
            if (i == lastIndex)
                return true;

        return false;
    }
}

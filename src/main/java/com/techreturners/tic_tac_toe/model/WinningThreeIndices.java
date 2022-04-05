package com.techreturners.tic_tac_toe.model;

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

    protected boolean contains(int lastPosition) {
        for (int i : wti)
            if (i == lastPosition)
                return true;

        return false;
    }
}

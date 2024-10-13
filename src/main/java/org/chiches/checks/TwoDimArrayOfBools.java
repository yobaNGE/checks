package org.chiches.checks;

public class TwoDimArrayOfBools {
    private static int size = 1000;
    private static boolean[][] bools = new boolean[size][size];

    public static int getSize() {
        return size;
    }

    public static boolean[][] getBools() {
        return bools;
    }

    public static void setBools(int x, int y, boolean value) {
        TwoDimArrayOfBools.bools[x][y] = value;
    }
}

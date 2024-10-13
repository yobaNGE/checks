package org.chiches.checks;

import org.springframework.stereotype.Component;

@Component
public class ArrayOfBools {
    private static final int size = 100000;
    private static boolean[] bools = new boolean[size];

    public boolean[] getBools() {
        return bools;
    }

    public void setBools(boolean[] bools) {
        this.bools = bools;
    }

    public static void setBool(int x, boolean value) {
        bools[x] = value;
    }

    public int getSize() {
        return size;
    }
}

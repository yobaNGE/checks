package org.chiches.checks;

public class BoolRequest {
    private int x;
    private boolean value;

    public BoolRequest() {
    }

    public BoolRequest(int x, boolean value) {
        this.x = x;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

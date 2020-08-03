package com.company;

public class Bed extends Point {
    public Bed(int x, int y) {
        super(x, y);
    }

    /**
     * 是否占用了该床位
     */
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}

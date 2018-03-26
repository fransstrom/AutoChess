package com.company;


public abstract class Piece implements iMove {
    int fromX;
    int fromY;
    int toX;
    int toY;
    String icon;
    Team color;


    public Piece(Team color) {
        this.color = color;
    }

    public boolean validMove() {
        return toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7;
    }


}

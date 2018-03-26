/*
package com.company;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(Team color) {
        super(color);
        this.icon = "\u265D";
    }

    public Bishop(int fromX, int fromY) {
        super(fromX, fromY);
    }

    @Override
    public ArrayList<Move> getMoves(Tile[][] board, int fromX, int fromY) {
        return null;
    }


    //Rules for if allowed to make the move.

    //Movement rule
    @Override
    public boolean collision(Tile[][] board) {
        //Diagonal bottom-right
        if (fromX < toX && fromY < toY)
            if (board[fromX + Math.abs(1)][fromY + Math.abs(1)].empty) {
                for (int i = 1; fromX + i < board.length; i++) {
                    if (board[fromX + i][fromY + i].empty) {
                        if (fromX + i == toX && fromY + i == toY) {
                            return true;
                        }
                    }
                }
            }


        return false;
    }
}*/

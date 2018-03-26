package com.company;

public class Tile {

    Piece piece;
    boolean empty;

    public Tile(Piece piece) {
        this.piece = piece;
        this.empty = false;
    }

    public Tile() {
        this.empty = true;
    }

    public Piece getPiece() {
        return this.piece;
    }

}



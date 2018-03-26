package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {

    Team color;
    List<Piece> pieces = new ArrayList<>();
    List<Move> moves = new ArrayList<>();
    List<Move> killMoves = new ArrayList<>();

    public Player(Team color) {
        this.color = color;
    }

}

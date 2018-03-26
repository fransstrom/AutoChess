package com.company;

import java.util.ArrayList;

public interface iMove {
    ArrayList<Move> getMoves(Tile[][] board);

    ArrayList<Move> getKill(Tile[][] board);
}

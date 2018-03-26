package com.company;

import java.util.ArrayList;

import static com.company.Team.BLACK;
import static com.company.Team.WHITE;


public class Pawn extends Piece {

    public Pawn(Team color) {

        super(color);

        this.icon = "\u265F";

    }

    @Override
    public boolean validMove() {
        return super.validMove();
    }

    @Override
    public ArrayList<Move> getMoves(Tile[][] board) {
        ArrayList<Move> moves = new ArrayList();
        //black piece
        if (fromY + 1 <= 7 && board[fromX][fromY].getPiece().color == BLACK && board[fromX][fromY + 1].empty) {
            moves.add(new Move(fromX, fromY, fromX, fromY + 1));
        }

        if (fromY + 2 <= 7 && fromY == 1 && board[fromX][fromY].getPiece().color == BLACK && board[fromX][fromY + 1].empty && board[fromX][fromY + 2].empty) {
            moves.add(new Move(fromX, fromY, fromX, fromY + 2));
        }
        //white piece

        if (fromY - 2 >= 0 && fromY == 6 && board[fromX][fromY].getPiece().color == WHITE && board[fromX][fromY - 2].empty && board[fromX][fromY - 1].empty) {
            moves.add(new Move(fromX, fromY, fromX, (fromY - 2)));
        }
        if (fromY - 1 >= 0 && board[fromX][fromY].getPiece().color == WHITE && board[fromX][(fromY - 1)].empty) {
            moves.add(new Move(fromX, fromY, fromX, (fromY - 1)));
        }


        return moves;
    }

    @Override
    public ArrayList<Move> getKill(Tile[][] board) {
        ArrayList<Move> killMoves = new ArrayList();

        //black piece
        if (board[fromX][fromY].getPiece().color == BLACK) {
            if (fromX + 1 <= 7 && !board[fromX + 1][fromY + 1].empty && board[fromX + 1][fromY + 1].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX + 1, fromY + 1));
            }

            if (fromX - 1 >= 0 && !board[fromX - 1][fromY + 1].empty && board[fromX - 1][fromY + 1].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX - 1, fromY + 1));
            }
        }

        //white piece
        if (board[fromX][fromY].getPiece().color == WHITE) {
            if (fromX + 1 <= 7 && !board[fromX + 1][fromY - 1].empty && board[fromX + 1][fromY - 1].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX + 1, fromY - 1));
            }
            if (fromX - 1 >= 0 && !board[fromX - 1][fromY - 1].empty && board[fromX - 1][fromY - 1].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX - 1, (fromY - 1)));
            }
        }


        return killMoves;
    }
}
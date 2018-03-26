package com.company;

import java.util.ArrayList;

public class Rook extends Piece {


    public Rook(Team color) {
        super(color);
        this.icon = "\u265C";
    }


    public ArrayList<Move> getMoves(Tile[][] board) {
        ArrayList<Move> moves = new ArrayList();

        for (int i = fromY + 1; i < board.length; i++) {
            if (!board[fromX][i].empty) {
                break;
            } else if (validMove() && board[fromX][i].empty) {
                moves.add(new Move(fromX, fromY, fromX, i));
            }

        }
        for (int i = fromY; i > 0; i--) {
            if (i - 1 >= 0 && !board[fromX][i - 1].empty) {
                break;
            } else if (i - 1 >= 0 && board[fromX][i - 1].empty) {
                moves.add(new Move(fromX, fromY, fromX, i - 1));
            }
        }
        for (int i = fromX; i > 0; i--) {
            if (i - 1 >= 0 && !board[i - 1][fromY].empty) {
                break;
            } else if (i - 1 >= 0 && board[i - 1][fromY].empty) {
                moves.add(new Move(fromX, fromY, i - 1, fromY));

            }

        }
        for (int i = fromX + 1; i < board.length; i++) {
            if (!board[i][fromY].empty) {
                break;
            } else if (validMove() && board[i][fromY].empty) {
                moves.add(new Move(fromX, fromY, i, fromY));
            }

        }
        return moves;
    }

    public ArrayList<Move> getKill(Tile[][] board) {
        ArrayList<Move> killMoves = new ArrayList();

        for (int i = fromY + 1; i < board.length; i++) {
            if (validMove() && !board[fromX][i].empty && board[fromX][i].getPiece().color == this.color) {
                break;
            }
            if (!board[fromX][i].empty && board[fromX][i].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX, i));
                i = board.length;
            } else if (board[fromX][i].empty) {
            }
        }

        for (int i = fromY; i > 0; i--) {
            if (!board[fromX][i - 1].empty && board[fromX][i - 1].getPiece().color == this.color) {
                break;
            }
            if (!board[fromX][i - 1].empty && board[fromX][i - 1].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, fromX, i - 1));
                i = -fromY;
            } else if (board[fromX][i - 1].empty) {
            }
        }

        for (int i = fromX; i > 0; i--) {
            if (!board[i][fromY].empty && board[i][fromY].getPiece().color == this.color) {
                break;
            }
            if (!board[i - 1][fromY].empty && board[i - 1][fromY].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, i - 1, fromY));
                i = -fromX;
            } else if (board[i - 1][fromY].empty) {
            }
        }

        for (int i = fromX + 1; i < board.length; i++) {
            if (!board[i][fromY].empty && board[i][fromY].getPiece().color == this.color) {
                break;
            }
            if (!board[i][fromY].empty && board[i][fromY].getPiece().color != this.color) {
                killMoves.add(new Move(fromX, fromY, i, fromY));
                i = board.length;
            } else if (board[i][fromY].empty) {

            }
        }
        return killMoves;
    }


}

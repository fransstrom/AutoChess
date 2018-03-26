package com.company;

import javax.swing.*;
import java.util.Collections;
import java.util.Random;
import java.util.function.Predicate;


import static com.company.Team.*;

public class Game {


    private Board board = new Board();
    private Tile[][] chessBoard = board.board;
    private Player player1 = new Player(WHITE);
    private Player player2 = new Player(BLACK);


    void start() {
        JFrame window = new JFrame("Chess");
        window.setSize(665, 700);
        window.setVisible(true);
        window.setDefaultCloseOperation(3);

        board.drawBoard(chessBoard);
        board.printBoard(window, chessBoard);

        System.out.println("\n\n\n");
        int counter = 0;
        while (true) {
            clearMoves(player1);
            clearMoves(player2);
            for (int i = 0; i < chessBoard.length; i++) {
                for (Tile[] aChessBoard : chessBoard) {
                    if (!aChessBoard[i].empty && aChessBoard[i].getPiece().color == player1.color) {
                        player1.pieces.add(aChessBoard[i].getPiece());
                    }
                    if (!aChessBoard[i].empty && aChessBoard[i].getPiece().color == player2.color) {
                        player2.pieces.add(aChessBoard[i].getPiece());
                    }
                }
            }
            if (counter % 2 == 0) {
                generateMove(player1);
                sleep(1000);
            } else {
                generateMove(player2);
                sleep(1000);
            }
            board.printBoard(window, chessBoard);
            counter++;
        }
    }



    private void generateMove(Player player) {
        player.pieces.stream().flatMap(p1 -> p1.getMoves(chessBoard).stream()).forEach(move -> player.moves.add(new Move(move.fromX, move.fromY, move.toX, move.toY)));
        player.pieces.removeIf(p -> p.getMoves(chessBoard).isEmpty());

        player.pieces.stream().flatMap(piece -> piece.getKill(chessBoard).
                stream()).
                forEach(m -> player.killMoves.add(new Move(m.fromX, m.fromY, m.toX, m.toY)));
        player.pieces.removeIf(p -> p.getKill(chessBoard).isEmpty());


        if (player.killMoves.isEmpty()) {
            try {
                //Om killistan är tom, ta ett vanligt random drag
                Collections.shuffle(player.moves);
                int fromXX = player.moves.get(0).fromX;
                int fromYY = player.moves.get(0).fromY;
                int toXX = player.moves.get(0).toX;
                int toYY = player.moves.get(0).toY;
                board.movePiece(chessBoard, fromXX, fromYY, toXX, toYY);
                System.out.println("\n" + String.valueOf((char) ('@' + fromXX+1))  + (fromYY+1) + " -> " +String.valueOf((char) ('@' + toXX+1)) + (toYY+1));

            } catch (Exception e) {
                //Spelet slutar när någon av spelarna har slut på moves
                System.out.println(player.color + " lost the game");
                System.exit(0);
            }
        } else {
            //Väljer ett mördardrag
            Collections.shuffle(player.killMoves);
            int fromXX = player.killMoves.get(0).fromX;
            int fromYY = player.killMoves.get(0).fromY;
            int toXX = player.killMoves.get(0).toX;
            int toYY = player.killMoves.get(0).toY;
            System.out.println("\n" + String.valueOf((char) ('@' + fromXX+1))  + (fromYY+1) + " -> " +String.valueOf((char) ('@' + toXX+1)) + (toYY+1));
            board.movePiece(chessBoard, fromXX, fromYY, toXX, toYY);
            clearMoves(player);
        }


    }

    private void clearMoves(Player player) {
        player.killMoves.clear();
        player.moves.clear();
        player.pieces.clear();
    }


    private void sleep(int milli) {


        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static com.company.Team.*;

public class Board {


    Tile[][] board = new Tile[8][8];

    public Board() {
        this.board = board;
    }

    public void drawBoard(Tile[][] chessBoard) {
        board[0][0] = new Tile(new Rook(BLACK));
        board[1][0] = new Tile(new Rook(BLACK));
        board[2][0] = new Tile(new Rook(BLACK));
        board[3][0] = new Tile(new Rook(BLACK));
        board[4][0] = new Tile(new Rook(BLACK));
        board[5][0] = new Tile(new Rook(BLACK));
        board[6][0] = new Tile(new Rook(BLACK));
        board[7][0] = new Tile(new Rook(BLACK));
        for (int i = 0; i < board.length; i++) {
            board[i][1] = new Tile(new Pawn(BLACK));
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 2; j <= 6; j++) {
                board[i][j] = new Tile();
            }
        }

        for (int i = 0; i < board.length; i++) {
            board[i][6] = new Tile(new Pawn(WHITE));
        }
        board[0][7] = new Tile(new Rook(WHITE));
        board[1][7] = new Tile(new Rook(WHITE));
        board[2][7] = new Tile(new Rook(WHITE));
        board[3][7] = new Tile(new Rook(WHITE));
        board[4][7] = new Tile(new Rook(WHITE));
        board[5][7] = new Tile(new Rook(WHITE));
        board[6][7] = new Tile(new Rook(WHITE));
        board[7][7] = new Tile(new Rook(WHITE));

        //Tilldelar koordinater till pjäserna
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (!board[j][i].empty) {
                    Piece fromPiece = chessBoard[j][i].getPiece();
                    fromPiece.fromX = j;
                    fromPiece.fromY = i;
                }
            }
        }
    }

    public void printBoard(JFrame window, Tile[][] board) {
        JPanel boardPanel = new JPanel(new GridLayout(10, 9, 1, 1));
        Border padding = BorderFactory.createEmptyBorder(0, 0, 0, 65);
        boardPanel.setBorder(padding);

        for (int ii = 0; ii < 9; ii++) {
            if (ii == 0) {
                boardPanel.add(new JLabel("", SwingConstants.CENTER));
            } else {
                boardPanel.add(new JLabel(String.valueOf((char) ('@' + ii)), SwingConstants.CENTER));
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    boardPanel.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                }
                JButton boardTile = new JButton();
                boardTile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                boardTile.setOpaque(true);
                boardTile.setEnabled(false);
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    boardTile.setBackground(Color.decode("#ffcc80"));
                } else {
                    boardTile.setBackground(Color.decode("#ff711c"));
                }
                if (!board[j][i].empty) {
                    JLabel piece = new JLabel(board[j][i].piece.icon, JLabel.CENTER);
                    piece.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                    piece.setFont(new Font("Serif", Font.PLAIN, 47));
                    if (board[j][i].piece.color == Team.WHITE) {
                        piece.setForeground(Color.WHITE);
                    }
                    if (board[j][i].piece.color == Team.BLACK) {
                        piece.setForeground(Color.BLACK);
                    }
                    boardTile.add(piece);
                }
                boardPanel.add(boardTile);

            }
        }
        //TODO List of moves
        JLabel boardList = new JLabel("");
        boardList.setFont(new Font("San-Serif", Font.PLAIN, 20));
        boardPanel.add(boardList);
        window.add(boardPanel);
        boardPanel.revalidate();
        window.revalidate();
    }


    public Tile[][] movePiece(Tile[][] chessBoard, int fromX, int fromY, int toX, int toY) {

        Piece fromPiece = chessBoard[fromX][fromY].getPiece();
        chessBoard[toX][toY] = chessBoard[fromX][fromY];
        chessBoard[fromX][fromY] = new Tile();
        fromPiece.fromX = toX;
        fromPiece.fromY = toY;

/*        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (j % 8 == 0) {
                    System.out.println();
                }
                if (!chessBoard[j][i].empty) {
                    System.out.print(chessBoard[j][i].getPiece().icon + " ");
                } else {
                    System.out.print("   ");
                }

            }

        }*/
        return chessBoard;
    }


}

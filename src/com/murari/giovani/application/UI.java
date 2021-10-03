package com.murari.giovani.application;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessMatch;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    //colors source: https://github.com/acenelio/chess-system-java/blob/master/src/application/UI.java
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String chessColumns = "abcdefgh";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(ANSI_RESET);
    }

    public static void printMatch(ChessMatch chessMatch) {
        clearScreen();
        printHeader(chessMatch.getCurrentPlayer().toString() + " Plays");
        printCapturedPieces(chessMatch.getCaptured());
        printBoard(chessMatch.getBoard());
        System.out.println();
        if (!chessMatch.isCheckMate()) {
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.isCheck()) {
                System.out.println("CHECK!");
            }
        }
        else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
        }


    }

    public static Position readPosition(Scanner sc){
        try {
            String s = sc.nextLine();
            System.out.println("%%%%%%%%%%%%%"+s);
            int column = chessColumns.indexOf(s.charAt(0));
            System.out.println("-------------"+column);
            int row = Integer.parseInt(s.substring(1)) - 1;
            System.out.println("-------------------"+row);
            return new Position(row, column);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    public static void printHeader(String title){
        System.out.print(ANSI_YELLOW);
        System.out.printf("========%s========", title);
        System.out.println();
        System.out.print(ANSI_RESET);
    }

    public static void printBackground(int mod){
        if (mod == 0){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        else {
            System.out.print(ANSI_CYAN_BACKGROUND);
        }
    }

    public static void printPiece(Position position, ChessPiece piece, boolean possibleMove){
        if (possibleMove){
            System.out.print(ANSI_GREEN_BACKGROUND);
        }
        else {
            printBackground(position.sumRowColumn() % 2);
        }
        if (piece != null) {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE);
                System.out.print(piece);
                System.out.print(ANSI_RESET);
            } else {
                System.out.print(ANSI_BLACK);
                System.out.print(piece);
                System.out.print(ANSI_RESET);
            }
        }
        else {
            System.out.print("   ");
            System.out.print(ANSI_RESET);
        }
    }

    public static void printBoard(Board board) {
        for(int row = 0; row < board.getRows(); row ++){
            System.out.print(ANSI_RESET);
            System.out.print((row+1) + " ");
            for(int column = 0; column < board.getColumns(); column ++){
                    printPiece(new Position(row, column), (ChessPiece) board.piece(new Position(row, column)), false);
            }
            System.out.println();
        }
        System.out.println("   a  b  c  d  e  f  g  h ");
    }

    public static void printBoard(Board board, boolean[][] possibleMoves) {
        for(int row = 0; row < board.getRows(); row ++){
            System.out.print(ANSI_RESET);
            System.out.print((row+1) + " ");
            for(int column = 0; column < board.getColumns(); column ++){
                printPiece(new Position(row, column), (ChessPiece) board.getPieces()[row][column], possibleMoves[row][column]);
            }
            System.out.println();
        }
        System.out.print(ANSI_RESET);
        System.out.println("   a  b  c  d  e  f  g  h ");
    }

    public static int printWelcome(Scanner sc){
        try {
            System.out.print(ANSI_YELLOW);

            printHeader("Welcome!");
            System.out.println("1 - NEW GAME");
            System.out.println("2 - EXIT");
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return sc.nextInt();
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        System.out.print(ANSI_YELLOW);
        System.out.println("Captured pieces:");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_YELLOW);
        System.out.print("Black: ");
        System.out.print(ANSI_BLACK);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
        System.out.println();
    }

}

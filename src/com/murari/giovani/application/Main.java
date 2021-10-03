package com.murari.giovani.application;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.BoardException;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessException;
import com.murari.giovani.chess.ChessMatch;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if(UI.printWelcome(sc) == 1){

            ChessMatch chessMatch = new ChessMatch();


            //while (!chessMatch.isCheckMate()) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch);
                    System.out.println();
                    sc.nextLine();
                    System.out.print("Source: ");
                    Position source = UI.readPosition(sc);
                    chessMatch.validateSource(source);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getBoard(), possibleMoves);
                    System.out.println();
                    System.out.print("Target: ");
                    Position target = UI.readPosition(sc);

                    chessMatch.performChessMove(source, target);

                    //if (capturedPiece != null) {
                    //    captured.add(capturedPiece);
                    //}

//                    if (chessMatch.getPromoted() != null) {
//                        System.out.print("Enter piece for promotion (B/N/R/Q): ");
//                        String type = sc.nextLine();
                       // chessMatch.replacePromotedPiece(type);
//                    }
                //} catch (ChessException e) {
                   // System.out.println(e.getMessage());
                   // sc.nextLine();
                } catch (InputMismatchException | BoardException | ChessException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
           // }
        }

        sc.close();
    }

}

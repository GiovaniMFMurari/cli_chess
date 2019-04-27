package com.giovani.chess;

import com.giovani.board.Board;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;
    private Board board;

    public ChessMatch(){
        new Board(8, 8);
    }

    public ChessMatch(int turn, Color currentPlayer, boolean check, boolean checkMate, ChessPiece enPassantVulnerable, ChessPiece promoted, Board board) {
        this.turn = turn;
        this.currentPlayer = currentPlayer;
        this.check = check;
        this.checkMate = checkMate;
        this.enPassantVulnerable = enPassantVulnerable;
        this.promoted = promoted;
        this.board = board;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public void setEnPassantVulnerable(ChessPiece enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ChessPiece[][] getPieces() {
        return (ChessPiece[][]) board.getPieces();
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {

    }

    public ChessPosition performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

    }

    public ChessPiece replacePromoted(String type) {

    }
}

package com.murari.giovani.chess;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.BoardException;
import com.murari.giovani.board.Piece;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;
    private Board board;
    List<ChessPiece> captured = new ArrayList<ChessPiece>();

    public ChessMatch() {
        this.turn = 0;
        this.currentPlayer = Color.WHITE;
        this.check = false;
        this.checkMate = false;
        this.board = new Board(8, 8);
        setup();
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

    public List<ChessPiece> getCaptured() {
        return captured;
    }

    public void setCaptured(List<ChessPiece> captured) {
        this.captured = captured;
    }

    private void setup(){
        try {
            board.placePiece(new Rook(new Position(0, 0), board, Color.BLACK, 0), new Position(0, 0));
            board.placePiece(new Knight(new Position(0, 1), board, Color.BLACK, 0), new Position(0, 1));
            board.placePiece(new Bishop(new Position(0, 2), board, Color.BLACK, 0), new Position(0, 2));
            board.placePiece(new Queen(new Position(0, 3), board, Color.BLACK, 0), new Position(0, 3));
            board.placePiece(new King(new Position(0, 4), board, Color.BLACK, 0), new Position(0, 4));
            board.placePiece(new Bishop(new Position(0, 5), board, Color.BLACK, 0), new Position(0, 5));
            board.placePiece(new Knight(new Position(0, 6), board, Color.BLACK, 0), new Position(0, 6));
            board.placePiece(new Rook(new Position(0, 7), board, Color.BLACK, 0), new Position(0, 7));

            for(int column = 0; column < board.getColumns(); column++){
                board.placePiece(new Pawn(new Position(1, column), board, Color.BLACK), new Position(1, column));
                board.placePiece(new Pawn(new Position(6, column), board, Color.WHITE), new Position(6, column));
            }

            board.placePiece(new Rook(new Position(7, 0), board, Color.WHITE, 0), new Position(7, 0));
            board.placePiece(new Knight(new Position(7, 1), board, Color.WHITE, 0), new Position(7, 1));
            board.placePiece(new Bishop(new Position(7, 2), board, Color.WHITE, 0), new Position(7, 2));
            board.placePiece(new Queen(new Position(7, 3), board, Color.WHITE, 0), new Position(7, 3));
            board.placePiece(new King(new Position(7, 4), board, Color.WHITE, 0), new Position(7, 4));
            board.placePiece(new Bishop(new Position(7, 5), board, Color.WHITE, 0), new Position(7, 5));
            board.placePiece(new Knight(new Position(7, 6), board, Color.WHITE, 0), new Position(7, 6));
            board.placePiece(new Rook(new Position(7, 7), board, Color.WHITE, 0), new Position(7, 7));

        }
        catch (BoardException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validatePosition(Position position) {
        if (! board.positionExists(position)) {
            throw new BoardException("There is no such position in this board.");
        }
    }

    public void validateSource(Position position) throws BoardException, ChessException {
        validatePosition(position);
        if (!board.hasPiece(position)) {
            throw new ChessException("There is no piece here!");
        }
        if (ChessPiece.toChessPiece(board.piece(position)).getColor() != currentPlayer) {
            throw new ChessException("This piece is not yours!");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible move with this piece, choose another one.");
        }
    }

    public void validateTarget(Piece piece, Position position) throws ChessException {
        validatePosition(position);
        if (! piece.possibleMove(position)) {
            throw new ChessException("Can't move here!");
        }
    }



    public boolean[][] possibleMoves(Position position) {
        return board.piece(position).possibleMoves();
    }

    public void performChessMove(Position sourcePosition, Position targetPosition) {
        Piece piece = board.piece(sourcePosition);
        try {

        }
        catch(Exception e) {

        }

    }

    public void replacePromoted(String type) {

    }
}

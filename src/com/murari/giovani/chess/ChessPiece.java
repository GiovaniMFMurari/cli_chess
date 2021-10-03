package com.murari.giovani.chess;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.board.Piece;

public abstract class ChessPiece extends Piece {
    protected Color color;
    protected int moveCount = 0;

    public ChessPiece() {
        super();
    }

    public ChessPiece(Position position, Board board, Color color) {
        super(position, board);
        this.color = color;
    }

    public ChessPiece(Position position, Board board, Color color, int moveCount) {
        super(position, board);
        this.color = color;
        this.moveCount = moveCount;
    }

    protected static ChessPiece toChessPiece(Piece piece) {
        return (ChessPiece) piece;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMoveCount() {
        return moveCount;
    }


    protected boolean isOpponentPiece(ChessPiece piece){
        return color != piece.getColor();
    }

    protected boolean isOpponentPiece(Position position){
        return (color != toChessPiece(board.piece(position)).getColor() && !toChessPiece(board.piece(position)).toString().equals(" K "));
    }

    protected void increaseMoveCount(){
        moveCount += 1;
    }

    protected void decreaseMoveCount(){
        moveCount -= 1;
    }

    Position startPosition(){
        return position
    }
}

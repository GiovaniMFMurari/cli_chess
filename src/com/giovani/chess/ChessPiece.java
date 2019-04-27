package com.giovani.chess;

import com.giovani.board.Position;

public abstract class ChessPiece extends com.giovani.board.Piece {
    Color color;
    int moveCount = 0;

    public ChessPiece() {
        super();
    }

    public ChessPiece(Position position, Color color, int moveCount) {
        super(position);
        this.color = color;
        this.moveCount = moveCount;
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

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public ChessPosition getChessPosition(){
        return new ChessPosition().
    }

    protected boolean isThereOpponentPiece(Position position){
        return true;
    }

    protected void increaseMoveCount(){
        moveCount += 1;
    }

    protected void decreaseMoveCount(){
        moveCount -= 1;
    }
}

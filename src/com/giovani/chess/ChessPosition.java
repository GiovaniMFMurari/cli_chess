package com.giovani.chess;

import com.giovani.board.Position;

public final class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(){
    }

    public ChessPosition(int row, char column){
        this.row = row;
        this.column = column;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    protected Position toPosition(){

    }

    protected ChessPosition fromPosition(Position position){
        return new ChessPosition(row = position.getRow(), column = Character.forDigit(position.getColumn(), 16));
    }
}

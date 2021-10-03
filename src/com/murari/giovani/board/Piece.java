package com.murari.giovani.board;

public abstract class Piece {
    protected Position position;
    protected Board board;

    public Piece(){
    }

    public Piece(Position position, Board board){
        this.position = position;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        for (int row = 0; row < possibleMoves().length; row++){
            for (int column = 0; column < possibleMoves()[row].length; column++){
                if (possibleMoves()[row][column] == true){
                    return true;
                }
            }
        }
        return false;
    }
}

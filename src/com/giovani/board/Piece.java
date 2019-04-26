package com.giovani.board;

public abstract class Piece {
    private Position position;

    public Piece(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
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

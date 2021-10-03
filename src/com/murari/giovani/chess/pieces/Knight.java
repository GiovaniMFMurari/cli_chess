package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class Knight extends ChessPiece {

    public Knight(Position position, Board board, Color color, int moveCount) {
        super(position, board,  color, moveCount);
    }

    @Override
    public String toString(){
        return " N ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                if (((row - getPosition().getRow() == 2 || row - getPosition().getRow() == -2) && (column - getPosition().getColumn() == 1 || column - getPosition().getColumn() == -1))
                    || ((column - getPosition().getColumn() == 2 || column - getPosition().getColumn() == -2) && (row - getPosition().getRow() == 1 || row - getPosition().getRow() == -1))) {
                    if (board.hasPiece(new Position(row, column))
                            && ChessPiece.toChessPiece(board.piece(new Position(row, column))).getColor() == getColor()) {
                        possibleMoves[row][column] = false;
                    }
                    else {
                        possibleMoves[row][column] = true;
                    }
                }
                else {
                    possibleMoves[row][column] = false;
                }
            }
        }

        return possibleMoves;
    }
}

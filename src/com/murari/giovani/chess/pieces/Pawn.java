package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class Pawn extends ChessPiece {

    public Pawn(Position position, Board board, Color color) {
        super(position, board,  color);
    }

    @Override
    public String toString(){
        return (color == Color.WHITE)? " \u2659 " : " \u265f ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
        if (color == Color.WHITE) {
            int firstRow = 6;
            int front = -1;
        }
        else {
            int firstRow = 1;
            int front = -1;
        }







        if (color == Color.BLACK ) {
            for (int row = 0; row < board.getRows(); row++) {
                for (int column = 0; column < board.getColumns(); column++) {
                    if ((row == position.getRow() + 1)
                            && (column == position.getColumn())
                            && !board.hasPiece(new Position(row, column))) {
                        possibleMoves[row][column] = true;
                    }
                    else if ((row == position.getRow() + 2 && column == position.getColumn())
                            && (position.getRow() == 1 && !board.hasPiece(new Position(row, column)))) {
                        possibleMoves[row][column] = true;
                    }
                    else if ((row == position.getRow() + 1
                            && (column == position.getColumn() - 1 || column == position.getColumn() + 1))
                            && board.hasPiece(new Position(row, column))) {
                        possibleMoves[row][column] = true;
                    }
                    else {
                        possibleMoves[row][column] = false;
                    }
                }
            }
        }
        else {
            for (int row = 0; row < board.getRows(); row++) {
                for (int column = 0; column < board.getColumns(); column++) {
                    if ((row == position.getRow() - 1)
                            && (column == position.getColumn())
                            && !board.hasPiece(new Position(row, column))) {
                        possibleMoves[row][column] = true;
                    }
                    else if ((row == position.getRow() - 2 && column == position.getColumn())
                            && (position.getRow() == 6 && !board.hasPiece(new Position(row, column)))) {
                        possibleMoves[row][column] = true;
                    }
                    else if ((row == position.getRow() - 1
                            && (column == position.getColumn() - 1 || column == position.getColumn() + 1))
                            && board.hasPiece(new Position(row, column))) {
                        possibleMoves[row][column] = true;
                    }
                    else {
                        possibleMoves[row][column] = false;
                    }
                }
            }
        }

        return possibleMoves;
    }
}

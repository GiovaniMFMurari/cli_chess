package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class Queen extends ChessPiece {

    public Queen(Position position, Board board, Color color, int moveCount) {
        super(position, board,  color, moveCount);
    }

    @Override
    public String toString(){
        return " Q ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                if ((row - getPosition().getRow() == column - getPosition().getRow() || row - getPosition().getRow() == (column - getPosition().getRow()) * -1)
                        || (row == getPosition().getRow() || column == getPosition().getColumn())) {
                    if (board.hasPiece(new Position(row, column))
                            && ChessPiece.toChessPiece(board.piece(new Position(row, column))).getColor() == getColor()) {
                        possibleMoves[row][column] = false;
                        row = 8;
                        column = 8;
                    }
                    else if (board.hasPiece(new Position(row, column))
                            && ChessPiece.toChessPiece(board.piece(new Position(row, column))).getColor() != getColor()) {
                        possibleMoves[row][column] = true;
                        row = 8;
                        column = 8;
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

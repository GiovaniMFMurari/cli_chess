package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class Rook extends ChessPiece {

    public Rook(Position position, Board board, Color color, int moveCount) {
        super(position, board,  color, moveCount);
    }

    @Override
    public String toString(){
        return " R ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
        //north
        for (int row = getPosition().getRow() - 1; row >= 0; row --){
            if (board.hasPiece(new Position(row, getPosition().getColumn()))) {
                if (isOpponentPiece((ChessPiece) board.piece(new Position(row, getPosition().getColumn())))) {
                    possibleMoves[row][getPosition().getColumn()] = true;
                }
                row = -1;
            }
            else if (!board.hasPiece(new Position(row, getPosition().getColumn()))) {
                possibleMoves[row][getPosition().getColumn()] = true;
            }
        }
        //south
        for (int row = getPosition().getRow() + 1; row < board.getRows(); row ++){
            if (board.hasPiece(new Position(row, getPosition().getColumn()))) {
                if (isOpponentPiece((ChessPiece) board.piece(new Position(row, getPosition().getColumn())))) {
                    possibleMoves[row][getPosition().getColumn()] = true;
                }
                row = board.getRows();
            }
            else if (!board.hasPiece(new Position(row, getPosition().getColumn()))) {
                possibleMoves[row][getPosition().getColumn()] = true;
            }
        }
        //west
        for (int column = getPosition().getColumn() - 1; column >= 0; column --){
            if (board.hasPiece(new Position(getPosition().getRow(), column))) {
                if (isOpponentPiece((ChessPiece) board.piece(new Position(getPosition().getRow(), column)))) {
                    possibleMoves[getPosition().getRow()][column] = true;
                }
                column = -1;
            }
            else if (!board.hasPiece(new Position(getPosition().getRow(), column))) {
                possibleMoves[getPosition().getRow()][column] = true;
            }
        }
        //east
        for (int column = getPosition().getColumn() + 1; column < board.getColumns(); column ++){
            if (board.hasPiece(new Position(getPosition().getRow(), column))) {
                if (isOpponentPiece((ChessPiece) board.piece(new Position(getPosition().getRow(), column)))) {
                    possibleMoves[getPosition().getRow()][column] = true;
                }
                column = board.getColumns();
            }
            else if (!board.hasPiece(new Position(getPosition().getRow(), column))) {
                possibleMoves[getPosition().getRow()][column] = true;
            }
        }

        return possibleMoves;
    }
}

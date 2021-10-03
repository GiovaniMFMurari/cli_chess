package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class Bishop extends ChessPiece {


    public Bishop(Position position, Board board, Color color, int moveCount) {
        super(position, board,  color, moveCount);
    }

    @Override
    public String toString(){
        return " B ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
        Position p = new Position(0, 0);

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isOpponentPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isOpponentPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isOpponentPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isOpponentPiece(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        return possibleMoves;
    }
}

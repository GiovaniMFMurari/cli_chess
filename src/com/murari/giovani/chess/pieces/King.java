package com.murari.giovani.chess.pieces;

import com.murari.giovani.board.Board;
import com.murari.giovani.board.Position;
import com.murari.giovani.chess.ChessPiece;
import com.murari.giovani.chess.Color;

public final class King extends ChessPiece {

    public King(Position position, Board board, Color color, int moveCount) {
        super(position, board,  color, moveCount);
    }

    @Override
    public String toString(){
        return " K ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];

        for (int i = -1, j= -1; i <= 1;) {
            Position position = new Position(getPosition().getRow() + i, getPosition().getColumn() + j);
            if (getBoard().positionExists(position) && (!getBoard().hasPiece(position) || isOpponentPiece(position))) {
                possibleMoves[position.getRow()][position.getColumn()] = true;
            }
            j++;
            if (j > 1) {
                i++;
                j = -1;
            }
        }

        return possibleMoves;
    }
}

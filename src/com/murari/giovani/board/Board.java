package com.murari.giovani.board;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces =  new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public boolean positionExists(Position position){
        if (position.getRow() < 0
                || position.getColumn() < 0
                || position.getRow() > rows - 1
                || position.getColumn() > columns - 1
        ){
            return false;
        }
        return true;
    }

    public Piece piece(Position position) throws BoardException {
        if (positionExists(position) == false){
            throw  new BoardException("There is no such position.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public boolean hasPiece(Position position) throws BoardException {
        if (piece(position) == null){
            return false;
        }
        return true;
    }

    public void placePiece(Piece piece, Position position) throws BoardException {
        if(hasPiece(position) == true){
            throw new BoardException("There is already a piece in this position.");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
    }

    public Piece removePiece(Position position) throws BoardException {
        if(hasPiece(position) == false){
            throw new BoardException("There is no piece in this position.");
        }
        Piece removed = piece(position);
        pieces[position.getRow()][position.getColumn()] = null;
        return removed;
    }
}

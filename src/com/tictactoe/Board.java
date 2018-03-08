package com.tictactoe;

public class Board {
    private final int size = 3;
    private CellMark[][] board = new CellMark[size][size];

    public Board(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = CellMark.EMPTY;
            }
        }
    }

    public CellMark getCell(int row, int col){
        return board[row][col];
    }

    public int getSize(){
        return size;
    }

    public void setX(int row, int col) {
        board[row][col] = CellMark.X;
    }

    public void setO(int row, int col) {
        board[row][col] = CellMark.O;
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
                if (board[row][col] == CellMark.EMPTY)
                    return false;

        return true;
    }

    public Combination getRow(int row) {
        CellMark[] symbols = new CellMark[size];

        for (int col = 0; col < size; col++)
            symbols[col] = getCell(row, col);

        return new Combination(symbols);
    }

    public Combination getColumn(int col) {
        CellMark[] symbols = new CellMark[size];

        for (int row = 0; row < size; row++)
            symbols[row] = getCell(row, col);

        return new Combination(symbols);
    }

    public Combination getPrimaryDiagonal() {
        CellMark[] symbols = new CellMark[size];

        for (int i = 0; i < size; i++) {
            symbols[i] = getCell(i, i);
        }

        return new Combination(symbols);
    }

    public Combination getSecondaryDiagonal() {
        CellMark[] symbols = new CellMark[size];

        for (int i = 0; i < size; i++)
            symbols[i] = getCell(i, size - i - 1);

        return new Combination(symbols);
    }
}

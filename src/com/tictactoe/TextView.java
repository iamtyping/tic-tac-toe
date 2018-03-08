package com.tictactoe;

public class TextView {
    private TextDevice textDevice;

    public TextView(TextDevice device){
        this.textDevice = device;
    }

    public void drawBoard(Board board){
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                CellMark cell = board.getCell(row, col);

                textDevice.print(toSymbol(cell));
            }

            textDevice.print("\n");
        }

        System.out.println();
    }

    private String toSymbol(CellMark cell) {
        switch (cell) {
            case X:
                return "X";
            case O:
                return "O";
            case EMPTY:
                return "·";
        }

        return null;
    }
}

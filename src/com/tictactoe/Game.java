package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void makeMove(Move move){
        if (move.getPlayer() == Player.X)
            board.setX(move.getRow(), move.getCol());
        else
            board.setO(move.getRow(), move.getCol());
    }

    public boolean canMakeMove(int row, int col) {
        return board.getCell(row, col) == CellMark.EMPTY;
    }

    public GameState getState() {
        for (Combination combination : collectCombinations()) {
            if (combination.isWinning())
                if (combination.getWinner() == CellMark.X)
                    return GameState.XWon;
                else
                    return GameState.OWon;
        }

        if (board.isFull())
            return GameState.Draw;
        else
            return GameState.InProgress;
    }

    private List<Combination> collectCombinations() {
        List<Combination> combinations = new ArrayList<>();

        for (int i = 0; i < board.getSize(); i++) {
            combinations.add(board.getRow(i));
            combinations.add(board.getColumn(i));
        }

        combinations.add(board.getPrimaryDiagonal());
        combinations.add(board.getSecondaryDiagonal());

        return combinations;
    }
}
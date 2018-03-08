package com.tictactoe.view.fx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HumanMoveHandler implements EventHandler<MouseEvent> {
    private final int row;
    private final int col;

    public HumanMoveHandler(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}

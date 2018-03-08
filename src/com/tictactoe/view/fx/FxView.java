package com.tictactoe.view.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FxView {
    private int size;

    public FxView(int size){

        this.size = size;
    }

    public void show() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FxView.fxml"));

        GridPane grid = (GridPane)root.lookup("#grid");

        initField(grid, size);

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setScene(scene);

        stage.show();
    }

    private void initField(GridPane grid, int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                Button button = new Button();
                button.setMinWidth(100);
                button.setMinHeight(100);

                button.setOnMouseClicked(new HumanMoveHandler(row, col));

                grid.add(button, col, row);
            }
        }
    }
}

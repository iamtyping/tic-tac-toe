import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void whenCreating_thenBoardIsEmpty(){
        Board board = new Board();

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                assertEquals(CellMark.EMPTY, board.getCell(i,j));
            }
        }
    }

    @Test
    public void whenCreating_thenDefaultSizeIs3() {
        Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void whenSettingX_thenSet() {
        Board board = new Board();

        board.setX(1, 1);

        assertEquals(CellMark.X, board.getCell(1, 1));
    }

    @Test
    public void whenSetting0_thenSet() {
        Board board = new Board();

        board.setO(1, 1);

        assertEquals(CellMark.O, board.getCell(1, 1));
    }

}
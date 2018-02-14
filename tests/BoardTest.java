import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void whenCreating_thenBoardIsEmpty(){
        Board board = new Board();

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                assertEquals(CellMark.EMPTY, board.getCell(row, col));
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

    @Test
    public void whenCheckingAllCells_thenBoardIsFull(){
        Board board = new Board();

        for (int row = 0; row < board.getSize(); row++)
            for (int col = 0; col < board.getSize(); col++)
                board.setX(row, col);

        boolean isFull = board.isFull();

        assertTrue(isFull);
    }

    @Test
    public void whenSomeCellsAreNotSet_thenBoardIsNotFull(){
        Board board = new Board();

        board.setX(2, 2);

        boolean isFull = board.isFull();

        assertFalse(isFull);
    }

    @Test
    public void whenGettingRow_thenCombinationIsCorrect(){
        Board board = new Board();

        CellMark[] cells = new CellMark[] {CellMark.X, CellMark.O, CellMark.X};

        int row = 2;

        for (int col = 0; col < board.getSize(); col++) {
            if (cells[col] == CellMark.X)
                board.setX(row, col);
            else
                board.setO(row, col);
        }

        Combination actual = board.getRow(row);
        Combination expected = new Combination(cells);

        assertEquals(expected, actual);
    }

    @Test
    public void whenGettingColumn_thenCombinationIsCorrect(){
        Board board = new Board();

        CellMark[] cells = new CellMark[] {CellMark.X, CellMark.O, CellMark.X};

        int col = 2;

        for (int row = 0; row < board.getSize(); row++) {
            if (cells[row] == CellMark.X)
                board.setX(row, col);
            else
                board.setO(row, col);
        }

        Combination actual = board.getColumn(col);
        Combination expected = new Combination(cells);

        assertEquals(expected, actual);
    }

    @Test
    public void whenGettingPrimaryDiagonal_thenCombinationIsCorrect(){
        Board board = new Board();

        CellMark[] cells = new CellMark[] {CellMark.X, CellMark.O, CellMark.X};

        for (int i = 0; i < board.getSize(); i++) {
            if (cells[i] == CellMark.X)
                board.setX(i, i);
            else
                board.setO(i, i);
        }

        Combination actual = board.getPrimaryDiagonal();
        Combination expected = new Combination(cells);

        assertEquals(expected, actual);
    }
}
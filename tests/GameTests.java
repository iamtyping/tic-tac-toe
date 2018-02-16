import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    public void whenInstantiating_thenNoProblems() {
        new Game(new Board());
    }

    @Test
    public void whenGameIsNotFinished_thenGameStateIsPending(){
        CellMark[][] cells = new CellMark[][] {
                {CellMark.X,     CellMark.EMPTY, CellMark.EMPTY},
                {CellMark.EMPTY, CellMark.EMPTY, CellMark.EMPTY},
                {CellMark.EMPTY, CellMark.EMPTY, CellMark.EMPTY},
        };

        Board board = createBoard(cells);
        Game game = new Game(board);

        GameState state = game.getState();

        assertEquals(GameState.InProgress, state);
    }

    @Test
    public void whenNoWinnerAndBoardIsFull_thenGameStateIsDraw(){
        CellMark[][] cells = new CellMark[][] {
                {CellMark.X, CellMark.X, CellMark.O},
                {CellMark.O, CellMark.O, CellMark.X},
                {CellMark.X, CellMark.O, CellMark.X},
        };

        Board board = createBoard(cells);
        Game game = new Game(board);

        GameState state = game.getState();

        assertEquals(GameState.Draw, state);
    }

    @Test
    public void whenWinnerIsX_thenGameStateIsXWon(){
        CellMark[][] cells = new CellMark[][] {
                {CellMark.X, CellMark.X, CellMark.X},
                {CellMark.O, CellMark.O, CellMark.X},
                {CellMark.X, CellMark.O, CellMark.O},
        };

        Board board = createBoard(cells);
        Game game = new Game(board);

        GameState state = game.getState();

        assertEquals(GameState.XWon, state);
    }

    @Test
    public void whenWinnerIsO_thenGameStateIsOWon(){
        CellMark[][] cells = new CellMark[][] {
                {CellMark.O, CellMark.X, CellMark.X},
                {CellMark.O, CellMark.O, CellMark.X},
                {CellMark.X, CellMark.O, CellMark.O},
        };

        Board board = createBoard(cells);
        Game game = new Game(board);

        GameState state = game.getState();

        assertEquals(GameState.OWon, state);
    }

    @Test
    public void whenMakingMove_thenBoardReflectsIt(){
        Board board = new Board();
        Game game = new Game(board);

        game.makeMove(new Move(Player.X, 1, 1));

        CellMark actual = board.getCell(1, 1);

        assertEquals(CellMark.X, actual);
    }

    @Test
    public void whenBoardCellIsEmpty_thenCanMakeMove(){
        Board board = new Board();
        Game game = new Game(board);

        boolean canMakeMove = game.canMakeMove(1, 1);

        assertTrue(canMakeMove);
    }

    @Test
    public void whenBoardCellIsSet_thenCanNotMakeMove(){
        Board board = new Board();
        Game game = new Game(board);

        game.makeMove(new Move(Player.O, 0, 0));

        boolean canMakeMove = game.canMakeMove(0, 0);

        assertFalse(canMakeMove);
    }

    private Board createBoard(CellMark[][] cells) {
        Board board = new Board();

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                CellMark state = cells[row][col];

                switch(state){
                    case X:
                        board.setX(row, col);
                        break;
                    case O:
                        board.setO(row, col);
                        break;
                    case EMPTY:
                        break;
                }
            }
        }

        return board;
    }
}
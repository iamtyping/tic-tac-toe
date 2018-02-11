import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleViewTest {
    @Test
    void whenDrawingEmptyBoard_thenDrawnCorrectly() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ConsoleView cw = new ConsoleView(new PrintStream(stream));

        Board board = new Board();
        cw.drawBoard(board);

        String actual = new String(stream.toByteArray());

        String expected = "···\n"+
                          "···\n"+
                          "···\n";

        assertEquals(expected, actual);
    }

    @Test
    void whenDrawingNonEmptyBoard_thenDrawnCorrectly() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ConsoleView cw = new ConsoleView(new PrintStream(stream));

        Board board = new Board();

        board.setO(1,1);
        board.setX(2,2);
        cw.drawBoard(board);

        String actual = new String(stream.toByteArray());

        String expected = "···\n"+
                          "·O·\n"+
                          "··X\n";

        assertEquals(expected, actual);
    }
}
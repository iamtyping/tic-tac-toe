import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleViewTest {
    @Test
    void whenDrawingBoard_thenNotImplementedYet() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ConsoleView cw = new ConsoleView(new PrintStream(stream));

        cw.drawBoard();

        String actual = new String(stream.toByteArray());

        assertEquals("Coming soon...\n", actual);
    }
}
import com.tictactoe.ConsoleDevice;
import com.tictactoe.TextDevice;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleDeviceTest {
    @Test
    void whenPrinting_thenPrintsToStandardSystemOut() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        TextDevice cw = new ConsoleDevice();
        cw.print("com.tictactoe.Program output");

        String actual = new String(stream.toByteArray());

        assertEquals("com.tictactoe.Program output", actual);
    }
}
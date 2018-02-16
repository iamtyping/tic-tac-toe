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
        cw.print("Program output");

        String actual = new String(stream.toByteArray());

        assertEquals("Program output", actual);
    }
}
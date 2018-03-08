import com.tictactoe.Board;
import com.tictactoe.TextDevice;
import com.tictactoe.TextView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextViewTest {
    @Test
    void whenDrawingEmptyBoard_thenDrawnCorrectly() {
        TestTextDevice device = new TestTextDevice();
        TextView cw = new TextView(device);

        Board board = new Board();
        cw.drawBoard(board);

        String actual = device.getText();

        String expected = "···\n" +
                          "···\n" +
                          "···\n";

        assertEquals(expected, actual);
    }

    @Test
    void whenDrawingNonEmptyBoard_thenDrawnCorrectly() {
        TestTextDevice device = new TestTextDevice();
        TextView cw = new TextView(device);

        Board board = new Board();

        board.setO(1,1);
        board.setX(2,2);

        cw.drawBoard(board);

        String actual = device.getText();

        String expected = "···\n" +
                          "·O·\n" +
                          "··X\n";

        assertEquals(expected, actual);
    }

    class TestTextDevice implements TextDevice {
        String state = "";

        @Override
        public void print(String str) {
            state += str;
        }

        public String getText(){
            return state;
        }
    }
}


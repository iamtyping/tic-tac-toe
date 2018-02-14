import java.io.PrintStream;

public class ConsoleView {

    public ConsoleView(PrintStream outputStream){
        this.outputStream = outputStream;
    }

    public void drawBoard(Board board){
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                CellMark cell = board.getCell(row, col);

                outputStream.print(toSymbol(cell));
            }

            outputStream.println();
        }
    }

    private String toSymbol(CellMark cell) {
        switch(cell){
            case X:
                return "X";
            case O:
                return "O";
            case EMPTY:
                return "·";
        }

        return null;
    }

    private PrintStream outputStream;
}

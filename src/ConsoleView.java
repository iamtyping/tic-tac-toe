import java.io.PrintStream;

public class ConsoleView {

    public ConsoleView(PrintStream outputStream){
        this.outputStream = outputStream;
    }

    public void drawBoard(Board board){
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                CellMark cell = board.getCell(i, j);

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

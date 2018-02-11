import java.io.PrintStream;

public class ConsoleView {

    public ConsoleView(PrintStream outputStream){
        this.outputStream = outputStream;
    }

    public void drawBoard(){
        outputStream.println("Coming soon...");
    }

    private PrintStream outputStream;
}

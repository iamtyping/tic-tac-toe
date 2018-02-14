public class Board {
    private final int size = 3;
    private CellMark[][] board = new CellMark[size][size];

    public Board(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = CellMark.EMPTY;
            }
        }
    }

    public CellMark getCell(int row, int col){
        return board[row][col];
    }

    public int getSize(){
        return size;
    }

    public void setX(int row, int col) {
        board[row][col] = CellMark.X;
    }

    public void setO(int row, int col) {
        board[row][col] = CellMark.O;
    }

    public boolean isFull(){
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board[i][j] == CellMark.EMPTY)
                    return false;

        return true;
    }
}

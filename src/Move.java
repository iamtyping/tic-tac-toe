import java.util.Objects;

public class Move {
    private Player player;
    private int row, col;

    public Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return row == move.row &&
                col == move.col &&
                player == move.player;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, row, col);
    }
}

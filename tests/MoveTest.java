import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    public void whenCreating_thenPlayerIsSet(){
        Move move = new Move(Player.X, 1, 2);

        assertEquals(Player.X, move.getPlayer());
    }

    @Test
    public void whenCreating_thenRowIsSet(){
        Move move = new Move(Player.X, 1, 2);

        assertEquals(1, move.getRow());
    }

    @Test
    public void whenCreating_thenColIsSet(){
        Move move = new Move(Player.X, 1, 2);

        assertEquals(2, move.getCol());
    }

    @Test
    public void whenComparingTwoIdenticalMoves_thenEqual(){
        Move move1 = new Move(Player.X, 1, 2);
        Move move2 = new Move(Player.X, 1, 2);

        assertEquals(move1, move2);
    }

    @Test
    public void whenComparingTwoDifferentMoves_thenEqual(){
        Move move1 = new Move(Player.X, 1, 2);
        Move move2 = new Move(Player.O, 0, 1);

        assertNotEquals(move1, move2);
    }
}
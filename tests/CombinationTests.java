import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationTests {
    @Test
    public void whenCombinationIsWinning_thenWinnerIsDetected() {
        CellMark[] values = {CellMark.X, CellMark.X, CellMark.X};
        Combination combination = new Combination(values);

        boolean isWinning = combination.isWinning();

        assertTrue(isWinning);
    }

    @Test
    public void whenCombinationIsNotWinning_thenWinnerIsNotDetected() {
        CellMark[] values = {CellMark.X, CellMark.O, CellMark.EMPTY};
        Combination combination = new Combination(values);

        boolean isWinning = combination.isWinning();

        assertFalse(isWinning);
    }
}
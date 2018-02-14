import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationTests {
    private Combination getWinningCombination(CellMark winner) {
        CellMark[] values = {winner, winner, winner};

        return new Combination(values);
    }

    private Combination getLosingCombination() {
        CellMark[] values = {CellMark.X, CellMark.O, CellMark.EMPTY};

        return new Combination(values);
    }

    @Test
    public void whenCombinationIsWinning_thenWinnerIsDetected() {
        Combination combination = getWinningCombination(CellMark.X);

        boolean isWinning = combination.isWinning();

        assertTrue(isWinning);
    }

    @Test
    public void whenCombinationIsWinning_thenWinnerIsIdentified(){
        Combination combination = getWinningCombination(CellMark.O);

        CellMark winner = combination.getWinner();

        assertEquals(CellMark.O, winner);
    }

    @Test
    public void whenCombinationIsNotWinning_thenWinnerIsNotDetected() {
        Combination combination = getLosingCombination();

        boolean isWinning = combination.isWinning();

        assertFalse(isWinning);
    }

    @Test
    public void whenComparingIdenticalCombinations_thenTheyAreEqual(){
        Combination combination1 = getLosingCombination();
        Combination combination2 = getLosingCombination();

        assertEquals(combination1, combination2);
    }

    @Test
    public void whenComparingDifferentCombinations_thenTheyAreDifferent(){
        Combination combination1 = getWinningCombination(CellMark.O);
        Combination combination2 = getLosingCombination();

        assertNotEquals(combination1, combination2);
    }
}
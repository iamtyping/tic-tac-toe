import java.util.Arrays;

public class Combination {
    private CellMark[] values;

    public Combination(CellMark[] values){
        this.values = values;
    }

    public boolean isWinning(){
        CellMark first = values[0];

        if (first == CellMark.EMPTY)
            return false;

        for (int i = 1; i < values.length; i++)
            if (values[i] != first)
                return false;

        return true;
    }

    public CellMark getWinner(){
        if (isWinning()){
            return values[0];
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}

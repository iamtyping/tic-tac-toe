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
}

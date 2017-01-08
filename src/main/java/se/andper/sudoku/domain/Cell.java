package se.andper.sudoku.domain;

/**
 * Created by Anders on 2017-01-08.
 */
public class Cell {

    protected int row;
    protected int column;

    public Cell(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}

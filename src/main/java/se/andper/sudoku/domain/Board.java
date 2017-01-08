package se.andper.sudoku.domain;

/**
 * Created by Anders on 2017-01-07.
 */
public class Board {

    public static final int BOARD_DIMENSION = 9;

    private int boxSize;
    private int[][] grid;

    public Board() {
    }

    public Board(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public Integer getNumber(Cell cell) {
        return grid[cell.getRow()][cell.getColumn()];
    }

    public void setNumber(Cell cell, int number) {
        grid[cell.getRow()][cell.getColumn()] = number;
    }

    public Cell getNextCell(Cell currentCell) {
        int newRow = currentCell.getRow();
        int newColumn = currentCell.getColumn();

        newColumn++;

        if (newColumn > BOARD_DIMENSION - 1) {
            newColumn = 0;
            newRow++;
        }

        if (newRow > BOARD_DIMENSION - 1) {
            return null;
        }

        return new Cell(newRow, newColumn);
    }

    public int calculateBoxSize() {
        if (boxSize == 0) {
            boxSize = (int) Math.sqrt(BOARD_DIMENSION);
        }
        return boxSize;
    }

    public String prettyPrint() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < BOARD_DIMENSION; row++) {
            for (int col = 0; col < BOARD_DIMENSION; col++) {
                result.append(getNumber(new Cell(row, col)));
                result.append(" ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}

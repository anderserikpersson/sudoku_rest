package se.andper.sudoku.domain;

/**
 * Created by Anders on 2017-01-08.
 */
public class BacktrackSudokuSolver implements SudokuSolver {

    Board board;

    @Override
    public boolean solve(final Board board) {
        this.board = board;
        return solveCell(new Cell(0, 0));
    }

    protected boolean solveCell(Cell cell) {
        if (cell == null) {
            return true;
        }

        if (board.getNumber(cell) != 0) {
            return solveCell(board.getNextCell(cell));
        }

        for (int num = 1; num <= 9; num++) {
            if (isNumValidForCell(cell, num)) {
                board.setNumber(cell, num);
                if (solveCell(board.getNextCell(cell))) {
                    return true;
                } else {
                    board.setNumber(cell, 0); // Reset
                }
            }
        }
        return false;
    }

    protected boolean isNumValidForCell(Cell cell, Integer num) {
        return isNumValidForRow(cell, num) && isNumValidForCol(cell, num) && isNumValidForBox(cell, num);
    }

    protected boolean isNumValidForRow(Cell cell, Integer num) {
        for (int col = 0; col < Board.BOARD_DIMENSION; col++) {
            if (board.getNumber(new Cell(cell.getRow(), col)) == num) {
                return false;
            }
        }
        return true;
    }

    protected boolean isNumValidForCol(Cell cell, Integer num) {
        for (int row = 0; row < Board.BOARD_DIMENSION; row++) {
            if (board.getNumber(new Cell(row, cell.getColumn())) == num) {
                return false;
            }
        }
        return true;
    }

    protected boolean isNumValidForBox(Cell cell, Integer num) {
        int boxSize = board.calculateBoxSize();
        int boxStartRow = (cell.getRow() / boxSize) * boxSize;
        int boxStartCol = (cell.getColumn() / boxSize) * boxSize;

        for (int currentRow = 0; currentRow < boxSize; currentRow++) {
            for (int currentCol = 0; currentCol < boxSize; currentCol++) {
                if (board.getNumber(new Cell(boxStartRow + currentRow, boxStartCol + currentCol)) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

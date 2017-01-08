package se.andper.sudoku.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Anders on 2017-01-08.
 */
public class BacktrackSudokuSolverTest {

    protected static int[][] solvableGrid = {
            {8, 0, 0, 0, 0, 9, 0, 0, 6},
            {0, 6, 0, 0, 1, 0, 5, 2, 0},
            {0, 3, 0, 6, 0, 0, 9, 8, 0},
            {0, 0, 4, 0, 0, 0, 6, 0, 0},
            {0, 7, 6, 1, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 6, 0, 9, 0},
            {0, 0, 3, 0, 6, 0, 0, 0, 0},
            {6, 0, 0, 0, 0, 2, 8, 0, 0},
            {0, 4, 0, 0, 7, 0, 0, 6, 0}
    };

    protected static int[][] emptyGrid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    protected static int[][] notSolvableGrid = {
            {1, 2, 0, 4, 5, 6, 7, 8, 9},
            {0, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    protected BacktrackSudokuSolver solver;

    @Before
    public void setup() {
        solver = new BacktrackSudokuSolver();
    }

    @Test
    public void solveNormal() {
        boolean isSolved = solver.solve(new Board(solvableGrid));
        assertThat(isSolved, is(true));
    }

    @Test
    public void solveEmpty() {
        boolean isSolved = solver.solve(new Board(emptyGrid));
        assertThat(isSolved, is(true));
    }

    @Test
    public void testNotSolvable() {
        boolean isSolved = solver.solve(new Board(notSolvableGrid));
        assertThat(isSolved, is(true));
    }
}
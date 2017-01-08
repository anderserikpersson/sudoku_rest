package se.andper.sudoku.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.andper.sudoku.domain.BacktrackSudokuSolver;
import se.andper.sudoku.domain.Board;
import se.andper.sudoku.domain.SudokuSolver;

/**
 * Created by Anders on 2017-01-07.
 */
@Controller
@EnableAutoConfiguration
public class SudokuController {

    protected SudokuSolver backtrackSolver = new BacktrackSudokuSolver();

    public static void main(String[] args) {
        SpringApplication.run(SudokuController.class, args);
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    public ResponseEntity<Board> solve(@RequestBody Board board) {
        boolean isSolved = backtrackSolver.solve(board);
        if (isSolved) {
            return new ResponseEntity<Board>(board, HttpStatus.OK);
        } else {
            return new ResponseEntity<Board>(board, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/solve/text", method = RequestMethod.POST)
    public ResponseEntity<String> solveReturnString(@RequestBody Board board) {
        boolean isSolved = backtrackSolver.solve(board);
        if (isSolved) {
            return new ResponseEntity<String>(board.prettyPrint(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(board.prettyPrint(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SudokuGenerator {

    public SudokuPuzzle generateRandomSudoku(SudokuPuzzleType puzzleType) {

        SudokuPuzzle puzzle = new SudokuPuzzle(puzzleType.getRows(), puzzleType.getColumns(), puzzleType.getBoxWidth(), puzzleType.getBoxHeight(), puzzleType.getValidValues());
        SudokuPuzzle copy = new SudokuPuzzle(puzzle);
/*
        Random randomGenerator = new Random();

        List<String> notUsedValidValues =  new ArrayList<String>(Arrays.asList(copy.getValidValues()));
        for(int r = 0;r < copy.getNumRows();r++) {
            int randomValue = randomGenerator.nextInt(notUsedValidValues.size());
            copy.makeMove(r, 0, notUsedValidValues.get(randomValue), true);
            notUsedValidValues.remove(randomValue);
        }

        //Bottleneck here need to improve this so that way 16x16 puzzles can be generated
        backtrackSudokuSolver(0, 0, copy);

        int numberOfValuesToKeep = (int)(0.22222*(copy.getNumRows()*copy.getNumRows()));

        for(int i = 0;i < numberOfValuesToKeep;) {
            int randomRow = randomGenerator.nextInt(puzzle.getNumRows());
            int randomColumn = randomGenerator.nextInt(puzzle.getNumColumns());

            if(puzzle.isSlotAvailable(randomRow, randomColumn)) {
                puzzle.makeMove(randomRow, randomColumn, copy.getValue(randomRow, randomColumn), false);
                i++;
            }
        }
        */
        puzzle.makeMove(0, 0, "8", false);
        puzzle.makeMove(0, 3, "4", false);
        puzzle.makeMove(0, 5, "6", false);
        puzzle.makeMove(0, 8, "7", false);
        puzzle.makeMove(1, 6, "4", false);
        puzzle.makeMove(2, 1, "1", false);
        puzzle.makeMove(2, 6, "6", false);
        puzzle.makeMove(2, 7, "5", false);
        puzzle.makeMove(3, 0, "5", false);
        puzzle.makeMove(3, 2, "9", false);
        puzzle.makeMove(3, 4, "3", false);
        puzzle.makeMove(3, 6, "7", false);
        puzzle.makeMove(3, 7, "8", false);
        puzzle.makeMove(4, 4, "7", false);
        puzzle.makeMove(5, 1, "4", false);
        puzzle.makeMove(5, 2, "8", false);
        puzzle.makeMove(5, 4, "2", false);
        puzzle.makeMove(5, 6, "1", false);
        puzzle.makeMove(5, 8, "3", false);
        puzzle.makeMove(6, 1, "5", false);
        puzzle.makeMove(6, 2, "2", false);
        puzzle.makeMove(6, 7, "9", false);
        puzzle.makeMove(7, 2, "1", false);
        puzzle.makeMove(8, 0, "3", false);
        puzzle.makeMove(8, 3, "9", false);
        puzzle.makeMove(8, 5, "2", false);
        puzzle.makeMove(8, 8, "5", false);
        return puzzle;
    }

    /**
     * Solves the sudoku puzzle
     * Pre-cond: r = 0,c = 0
     * Post-cond: solved puzzle
     * @param r: the current row
     * @param c: the current column
     * @return valid move or not or done
     * Responses: Erroneous data
     */
    public SudokuPuzzle autoFill(SudokuPuzzleType puzzleType){
        
        SudokuPuzzle puzzle = new SudokuPuzzle(puzzleType.getRows(), puzzleType.getColumns(), puzzleType.getBoxWidth(), puzzleType.getBoxHeight(), puzzleType.getValidValues());
        puzzle.makeMove(0, 0, "8", false);
        puzzle.makeMove(0, 1, "3", false);
        puzzle.makeMove(0, 2, "5", false);
        puzzle.makeMove(0, 3, "4", false);
        puzzle.makeMove(0, 4, "1", false);
        puzzle.makeMove(0, 5, "6", false);
        puzzle.makeMove(0, 6, "9", false);
        puzzle.makeMove(0, 7, "2", false);
        puzzle.makeMove(0, 8, "7", false);
        
        puzzle.makeMove(1, 0, "2", false);
        puzzle.makeMove(1, 1, "9", false);
        puzzle.makeMove(1, 2, "6", false);
        puzzle.makeMove(1, 3, "8", false);
        puzzle.makeMove(1, 4, "5", false);
        puzzle.makeMove(1, 5, "7", false);
        puzzle.makeMove(1, 6, "4", false);
        puzzle.makeMove(1, 7, "3", false);
        puzzle.makeMove(1, 8, "1", false);
        
        puzzle.makeMove(2, 0, "4", false);
        puzzle.makeMove(2, 1, "1", false);
        puzzle.makeMove(2, 2, "7", false);
        puzzle.makeMove(2, 3, "2", false);
        puzzle.makeMove(2, 4, "9", false);
        puzzle.makeMove(2, 5, "3", false);
        puzzle.makeMove(2, 6, "6", false);
        puzzle.makeMove(2, 7, "5", false);
        puzzle.makeMove(2, 8, "8", false);
        
        puzzle.makeMove(3, 0, "5", false);
        puzzle.makeMove(3, 1, "6", false);
        puzzle.makeMove(3, 2, "9", false);
        puzzle.makeMove(3, 3, "1", false);
        puzzle.makeMove(3, 4, "3", false);
        puzzle.makeMove(3, 5, "4", false);
        puzzle.makeMove(3, 6, "7", false);
        puzzle.makeMove(3, 7, "8", false);
        puzzle.makeMove(3, 8, "2", false);
        
        puzzle.makeMove(4, 0, "1", false);
        puzzle.makeMove(4, 1, "2", false);
        puzzle.makeMove(4, 2, "3", false);
        puzzle.makeMove(4, 3, "6", false);
        puzzle.makeMove(4, 4, "7", false);
        puzzle.makeMove(4, 5, "8", false);
        puzzle.makeMove(4, 6, "5", false);
        puzzle.makeMove(4, 7, "4", false);
        puzzle.makeMove(4, 8, "9", false);
        
        puzzle.makeMove(5, 0, "7", false);
        puzzle.makeMove(5, 1, "4", false);
        puzzle.makeMove(5, 2, "8", false);
        puzzle.makeMove(5, 3, "5", false);
        puzzle.makeMove(5, 4, "2", false);
        puzzle.makeMove(5, 5, "9", false);
        puzzle.makeMove(5, 6, "1", false);
        puzzle.makeMove(5, 7, "6", false);
        puzzle.makeMove(5, 8, "3", false);
        
        puzzle.makeMove(6, 0, "6", false);
        puzzle.makeMove(6, 1, "5", false);
        puzzle.makeMove(6, 2, "2", false);
        puzzle.makeMove(6, 3, "7", false);
        puzzle.makeMove(6, 4, "8", false);
        puzzle.makeMove(6, 5, "1", false);
        puzzle.makeMove(6, 6, "3", false);
        puzzle.makeMove(6, 7, "9", false);
        puzzle.makeMove(6, 8, "4", false);
        
        puzzle.makeMove(7, 0, "9", false);
        puzzle.makeMove(7, 1, "8", false);
        puzzle.makeMove(7, 2, "1", false);
        puzzle.makeMove(7, 3, "3", false);
        puzzle.makeMove(7, 4, "4", false);
        puzzle.makeMove(7, 5, "5", false);
        puzzle.makeMove(7, 6, "2", false);
        puzzle.makeMove(7, 7, "7", false);
        puzzle.makeMove(7, 8, "6", false);
        
        puzzle.makeMove(8, 0, "3", false);
        puzzle.makeMove(8, 1, "7", false);
        puzzle.makeMove(8, 2, "4", false);
        puzzle.makeMove(8, 3, "9", false);
        puzzle.makeMove(8, 4, "6", false);
        puzzle.makeMove(8, 5, "2", false);
        puzzle.makeMove(8, 6, "8", false);
        puzzle.makeMove(8, 7, "1", false);
        puzzle.makeMove(8, 8, "5", false);
        return puzzle;
    }
    private boolean backtrackSudokuSolver(int r, int c, SudokuPuzzle puzzle) {
        //If the move is not valid return false
        if(!puzzle.inRange(r,c)) {
            return false;
        }

        //if the current space is empty
        if(puzzle.isSlotAvailable(r, c)) {

            //loop to find the correct value for the space
            for(int i = 0;i < puzzle.getValidValues().length;i++) {

                //if the current number works in the space
                if(!puzzle.numInRow(r, puzzle.getValidValues()[i]) && !puzzle.numInCol(c,puzzle.getValidValues()[i]) && !puzzle.numInBox(r,c,puzzle.getValidValues()[i])) {

                    //make the move
                    puzzle.makeMove(r, c, puzzle.getValidValues()[i], true);

                    //if puzzle solved return true
                    if(puzzle.boardFull()) {
                        return true;
                    }

                    //go to next move
                    if(r == puzzle.getNumRows() - 1) {
                        if(backtrackSudokuSolver(0,c + 1,puzzle)) return true;
                    } else {
                        if(backtrackSudokuSolver(r + 1,c,puzzle)) return true;
                    }
                }
            }
        }

        //if the current space is not empty
        else {
            //got to the next move
            if(r == puzzle.getNumRows() - 1) {
                return backtrackSudokuSolver(0,c + 1,puzzle);
            } else {
                return backtrackSudokuSolver(r + 1,c,puzzle);
            }
        }

        //undo move
        puzzle.makeSlotEmpty(r, c);

        //backtrack
        return false;
    }
}

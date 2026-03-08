package dsasolutions.month1arrayspointers;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ValidSudoku {
    void main(){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'}, 
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        boolean isValid = isValidSudoku2(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }
    
    @SuppressWarnings("unused")
    boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new Set[9];
        Set<Character>[] col = new Set[9];
        Set<Character>[] box = new Set[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i]  = new HashSet<>();
        }

        //row 
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                if (board[i][j] != '.') {
                    if (row[i].contains(board[i][j])) {
                        return false;
                    }
                    row[i].add(board[i][j]);
                }
            }
        }

        //col
        for (int i = 0; i < box.length; i++) {
            
            for (int j = 0; j < box.length; j++) {
                if (board[j][i] != '.') {
                    if (col[i].contains(board[j][i])) {
                        return false;
                    }
                    col[i].add(board[j][i]);
                }
            }
        }
        //box checker alternative
        //all box are indexed from 0-8 
        //int boxIndex = (r / 3) * 3 + (c / 3); 
        //if (!boxes[boxIndex].add(val)) return false;

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                if (board[i][j] != '.') {
                    int boxIndex = (i/3) * 3 + (j/3);
                    if (box[boxIndex].contains(board[i][j])) {
                        return false;
                    }
                    box[boxIndex].add(board[i][j]);
                }
            }
        }


        // ////Approach 2
        // for (int i = 0; i < box.length; i++) {
        //     box[i] = new HashSet<>();
        //     for (int j = 0; j < box.length; j++) {
        //         int rowIdx = 3 * (i / 3) + j / 3;
        //         int colIdx = 3 * (i % 3) + j % 3;
        //         if (board[rowIdx][colIdx] != '.') {
        //             if (box[i].contains(board[rowIdx][colIdx])) {
        //                 return false;
        //             }
        //             box[i].add(board[rowIdx][colIdx]);
        //         }
        //     }
        // }

        return true;
    }

    boolean isValidSudoku2(char[][] sudoku){
        Set<Character>[] row = new Set[9];
        Set<Character>[] col = new Set[9];
        Set<Character>[] box = new Set[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i]  = new HashSet<>();
        }
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                char c = sudoku[i][j];
                if (c == '.') continue;
                if (!row[i].add(c)) return  false;
                if (!col[j].add(c)) return false;
                int boxIndex = (i/3) * 3 + (j/3);
                if (!box[boxIndex].add(c)) return false; 
            }
        }

        return true;
    }
}

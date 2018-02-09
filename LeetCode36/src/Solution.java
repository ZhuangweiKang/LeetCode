import java.util.HashMap;
import java.util.Map;

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //define a hashmap to count fluent of each number
        Map<String, Integer> nums = new HashMap<>();
        //check each row
        for (char[] row:board) {
            for (char num:row) {
                if ((!nums.keySet().contains(String.valueOf(num)))){
                    nums.put(String.valueOf(num), 1);
                }else {
                    if (num != '.') return false;
                }
            }
            nums.clear();
        }
        //check each column
        for (int i = 0; i < board.length; i++) {//column
            for (int j = 0; j < board.length; j++) {//row
                if (!nums.keySet().contains(String.valueOf(board[j][i]))){
                    nums.put(String.valueOf(board[j][i]), 1);
                }else {
                    if (board[j][i] != '.') return false;
                }
            }
            nums.clear();
        }
        //check each sub-box
        for (int i = 0; i < board.length;) {
            for (int j = 0; j < board.length;) {
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (!nums.keySet().contains(String.valueOf(board[k][l]))){
                            nums.put(String.valueOf(board[k][l]), 1);
                        }else {
                            if (board[k][l] != '.') return false;
                        }
                    }
                }
                nums.clear();
                j += 3;
            }
            i += 3;
        }
        return true;
    }
}

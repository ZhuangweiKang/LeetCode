/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */
class Solution {
    private int max = 0;
    private boolean flag = false;
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = (matrix[i][j] == 0) ? 0 : (nextzero(matrix, i, j) ? 1 : updateMatrixHelper(matrix, i, j, 0));
                max = 0;
                flag = false;
            }
        }
        return res;
    }

    private boolean nextzero(int[][] matrix, int i, int j) {
        return  ((i > 0 && matrix[i-1][j] == 0) || (j > 0 && matrix[i][j-1] == 0) || (i+1 < matrix.length && matrix[i+1][j] == 0) || (j+1< matrix[0].length && matrix[i][j+1] == 0));
    }

    private int updateMatrixHelper(int[][] matrix, int i, int j, int rec) {
        if ((i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] != 0 && matrix[i][j] != -1) && (!flag || rec < max)) {
            matrix[i][j] = -1;
            int res =  1 + Math.min(Math.min(updateMatrixHelper(matrix, i, j+1,rec+1), updateMatrixHelper(matrix, i+1, j,rec+1)), Math.min(updateMatrixHelper(matrix, i-1, j,rec+1), updateMatrixHelper(matrix, i, j-1,rec+1)));
            matrix[i][j] = 1;
            return res;
        }else {
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == 0) {
                max = rec;
                flag = true;
                return 0;
            }else {
                return 100000000;
            }
        }
    }
}
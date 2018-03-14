/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] vals = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    vals[i][j] = Math.min(vals[i-1][j-1], Math.min(vals[i][j-1], vals[i-1][j])) + 1;
                    res = Math.max(res, vals[i][j]);
                }
            }
        }
        return res*res;
    }
}

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] val = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                val[i][j] = Integer.MAX_VALUE;
        val[0][0] = grid[0][0];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                minPathSumHelper(i, j, grid, val, m, n);
        return val[m-1][n-1];
    }
    private void minPathSumHelper(int i, int j, int[][] grid, int[][] val, int m, int n) {
        if (i == m-1 && j != n-1)
            val[i][j+1] = Math.min(val[i][j] + grid[i][j+1], val[i][j+1]);
        else if (i != m-1 && j == n-1)
            val[i+1][j] = Math.min(val[i][j] + grid[i+1][j], val[i+1][j]);
        else if (i != m-1 && j != n-1){
            val[i+1][j] = Math.min(val[i][j] + grid[i+1][j], val[i+1][j]);
            val[i][j+1] = Math.min(val[i][j] + grid[i][j+1], val[i][j+1]);
        }
    }
}
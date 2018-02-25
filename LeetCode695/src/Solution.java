/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
class Solution {
    private int val = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxval = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxAreaOfIslandHelper(i, j, grid);
                maxval = Math.max(val, maxval);
                val = 0;
            }
        }
        return maxval;
    }

    private int maxAreaOfIslandHelper(int r, int c, int[][] grid){
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1){
            grid[r][c] = 0;
            val = 1 + maxAreaOfIslandHelper(r-1, c, grid) + maxAreaOfIslandHelper(r, c-1, grid) + maxAreaOfIslandHelper(r+1, c, grid) + maxAreaOfIslandHelper(r, c+1, grid);
        }else {
            return 0;
        }
        return val;
    }
}
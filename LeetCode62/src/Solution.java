/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */

import java.math.BigInteger;

//解法1：DP解法
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] map = new int[m][n];
        //第一行全部置为1
        for (int i = 0; i < n; i++) map[0][i] = 1;
        //第一列全部置为1
        for (int i = 0; i < m; i++) map[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
//解法2：数学解法
/*
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        else return fac(m+n-2).divide(fac(m-1)).divide(fac(n-1)).intValue();
    }
    //用来计算x的阶乘
    private BigInteger fac(int x) {
        if (x == 1) return new BigInteger("1");
        else return new BigInteger(Integer.toString(x)).multiply(fac(x-1));
    }
}*/

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
class Solution {
    public int numSquares(int n) {
        int[] vals = new int[n+1];
        vals[1] = 1;
        for (int i = 1; i <= n; i++)
            if (i == Math.pow((int) Math.sqrt(i), 2)) vals[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j < i; j++)
                    min = Math.min(min, vals[j * j] + vals[i - j * j]);
                vals[i] = min;
            }
        return vals[n];
    }
}
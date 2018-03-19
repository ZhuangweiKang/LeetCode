/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
//通式：F(i) = F(i-1) * F(n-i)
class Solution {
    public int numTrees(int n) {
        int[] val = new int[n+1];
        val[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                 val[i] += val[j-1] * val[i-j];
        return val[n];
    }
}


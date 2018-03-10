/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int m = nums.length;
        int[] val = new int[m];
        val[0] = nums[0];
        val[1] = nums[1];
        for (int i = 0; i < m; i++) {
            if (i+3 <= m-1)
                val[i+3] = Math.max(val[i]+nums[i+3], val[i+3]);
            if (i+2 <= m-1)
                val[i+2] = Math.max(val[i]+nums[i+2], val[i+2]);
        }
        return Math.max(val[m-1], val[m-2]);
    }
}
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int m = nums.length;
        int[] val = new int[m];
        val[0] = nums[0];
        int max_val = val[0];
        for (int i = 1; i < m; i++) {
            val[i] = Math.max(val[i-1] + nums[i], nums[i]);
            max_val = Math.max(val[i], max_val);
        }
        return max_val;
    }
}
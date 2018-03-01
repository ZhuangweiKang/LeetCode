class Solution {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        findTargetSumWaysHelper(nums, 0, S, 0);
        return count;
    }

    private void findTargetSumWaysHelper(int[] nums, int pos, int S, int current) {
        if (pos == nums.length) {
            if (current == S) count++;
            return;
        }
        findTargetSumWaysHelper(nums, pos+1, S, current + nums[pos]);
        findTargetSumWaysHelper(nums, pos+1, S, current-nums[pos]);
    }
}

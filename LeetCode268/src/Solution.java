class Solution {
    public int missingNumber(int[] nums) {
        int targetSum = nums.length * (nums.length + 1) / 2;
        for (int num:nums) targetSum -= num;
        return targetSum;
    }
}
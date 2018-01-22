/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 1:

Input: [1,3,5,6], 0
Output: 0

 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return mySearch(nums, 0, nums.length-1, target);
    }

    private int mySearch(int[] nums, int left, int right, int target){
        if (right < left) return left;
        int middle = (right - left)/2;
        if (nums[middle] > target)
            return mySearch(nums, left, middle-1, target);
        if (nums[middle] < target)
            return mySearch(nums, middle+1, right, target);
        return middle;
    }
}

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class Solution {
    private int start = -1, end = -1;
    public int[] searchRange(int[] nums, int target) {
        start = searchStart(nums, 0, nums.length-1, target);
        end = start != -1 ? searchEnd(nums, start, nums.length-1, target) : -1;
        return new int[]{start, end};
    }

    private int searchStart(int[] nums, int start_index, int end_index, int target) {
        int middle = (start_index + end_index) / 2;
        if (start_index <= end_index){
            if (nums[middle] >= target) {
                if (nums[middle] == target) start = middle;
                return searchStart(nums, start_index, middle - 1, target);
            }else if (nums[middle] < target) {
                return searchStart(nums, middle + 1, end_index, target);
            }
            if (nums[middle] == target) return middle;
        }
        return start;
    }

    private int searchEnd(int[] nums, int start_index, int end_index, int target) {
        int middle = (start_index + end_index) / 2;
        if (start_index <= end_index){
            if (nums[middle] <= target) {
                if (nums[middle] == target) end = middle;
                return searchEnd(nums, middle + 1, end_index, target);
            }else if (nums[middle] > target) {
                return searchEnd(nums, start_index, middle - 1, target);
            }
            if (nums[middle] == target) return middle;
        }
        return end;
    }

}
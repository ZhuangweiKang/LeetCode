/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBSTHelper(nums, start, middle-1);
        root.right = sortedArrayToBSTHelper(nums, middle+1, end);
        return root;
    }
}
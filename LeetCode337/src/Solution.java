/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
class Solution {
    private int max = 0;
    public int rob(TreeNode root) {
        robHelper(root);
        return max;
    }

    private void robHelper(TreeNode root) {
        if (root == null) return;
        max += root.val;
        if (root.left != null && root.right != null && root.left.val + root.right.val > root.val)
            max += root.left.val + root.right.val - root.val;
        if (root.left == null && root.right != null && root.right.val > root.val)
            max += root.right.val - root.val;
        if (root.right == null && root.left != null && root.left.val > root.val)
            max += root.left.val - root.val;
        robHelper(root.left);
        robHelper(root.right);
    }
}
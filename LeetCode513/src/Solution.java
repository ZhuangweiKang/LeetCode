import java.util.Stack;

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    private int max = Integer.MIN_VALUE;
    private int result;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueHelper(root);
        return result;
    }
    private void findBottomLeftValueHelper(TreeNode root) {
        if (root == null) return;
        stack.push(root);
        findBottomLeftValueHelper(root.left);
        if (stack.size() > max){
            max = stack.size();
            result = stack.peek().val;
        }
        findBottomLeftValueHelper(root.right);
        stack.pop();
    }
}
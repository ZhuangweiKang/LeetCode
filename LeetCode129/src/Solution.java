import java.util.Stack;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
class Solution {
    private Stack<Integer> stack = new Stack<>();
    private int pathsum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbersHelper(root);
        return pathsum;
    }

    private void sumNumbersHelper(TreeNode root) {
        if (root == null) return;
        stack.push(root.val);
        if (root.left == null && root.right == null){
            for (int i = 0; i < stack.size(); i++) {
                pathsum += stack.elementAt(i) * Math.pow(10, stack.size() - i -1);
            }
        }else{
            sumNumbersHelper(root.left);
            sumNumbersHelper(root.right);
        }
        stack.pop();
    }
}
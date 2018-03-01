import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
class Solution {
    private int max_depth = Integer.MIN_VALUE;
    private int depth = 0;
    private List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root);
        return res;
    }
    private void rightSideViewHelper(TreeNode root) {
        if (root == null) return;
        depth++;
        if (depth > max_depth) {
            res.add(root.val);
            max_depth = depth;
        }
        rightSideViewHelper(root.right);
        rightSideViewHelper(root.left);
        depth--;
    }
}
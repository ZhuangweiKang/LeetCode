import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
class Solution {
    private List<List<Integer>> storage = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return storage;
        pathSumHelper(root, sum, new Stack<Integer>());
        return storage;
    }

    private void pathSumHelper(TreeNode root, int sum, Stack<Integer> stack){
        stack.push(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val) storage.add(new ArrayList<>(stack));
        }
        if (root.left != null){
            pathSumHelper(root.left, sum - root.val, stack);
        }
        if (root.right != null){
            pathSumHelper(root.right, sum - root.val, stack);
        }
        stack.pop();
    }

}

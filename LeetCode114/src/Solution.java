import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
class Solution {
    private Queue<TreeNode> flattenT = new LinkedList<>();
    public void flatten(TreeNode root){
        flattenHelper(root);
        flattenT.poll();
        while (!flattenT.isEmpty()){
            root.left = null;
            root.right = flattenT.poll();
            root = root.right;
        }
    }
    private void flattenHelper(TreeNode root) {
        if (root == null) return;
        flattenT.add(root);
        flattenHelper(root.left);
        flattenHelper(root.right);
    }
}
import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreeHelper(root, "");
        return result;
    }

    public String binaryTreeHelper(TreeNode root, String str) {
        if (root == null) return "";
        if (root.right == null && root.left == null) {
            result.add(str + String.valueOf(root.val));
        }else {
            binaryTreeHelper(root.left, str + String.valueOf(root.val) + "->");
            binaryTreeHelper(root.right, str + String.valueOf(root.val) + "->");
        }
        return String.valueOf(root.val);
    }
}

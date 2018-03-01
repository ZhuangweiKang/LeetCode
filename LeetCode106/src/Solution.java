/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
class Solution {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length);
    }
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end-1) return null;
        index++;
        System.out.println(index);
        int middle = search(inorder, start, end, postorder[postorder.length-index]);
        TreeNode root = new TreeNode(inorder[middle]);
        root.right = buildTreeHelper(inorder, postorder, middle+1, end);
        root.left = buildTreeHelper(inorder, postorder, start, middle);
        return root;
    }
    private int search(int[] inorder, int start, int end, int target) {
        for (int i = start; i < end; i++)
            if (target == inorder[i]) return i;
        return -1;
    }
}
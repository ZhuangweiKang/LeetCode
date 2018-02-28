/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
class Solution {
    private int index = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        index++;
        int middle = searchNode(inorder, start, end, preorder[index]);
        TreeNode root = new TreeNode(inorder[middle]);
        root.left = buildTreeHelper(preorder, inorder, start, middle-1);
        root.right = buildTreeHelper(preorder, inorder, middle + 1, end);
        return root;
    }

    private int searchNode(int[] inorder, int start, int end, int target){
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target)
                return i;
        }
        return -1;
    }
}

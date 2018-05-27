class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode large = p.val > q.val ? p : q;
        TreeNode small = p == large ? q : p;
        return helper(root, large, small);
    }
    private TreeNode helper(TreeNode root, TreeNode large, TreeNode small) {
        if (root == null) return null;
        if ((large.val > root.val && small.val <= root.val)
                || (large.val >= root.val && small.val < root.val)) return root;
        if (small.val > root.val) return lowestCommonAncestor(root.right, large, small);
        return lowestCommonAncestor(root.left, large, small);
    }
}
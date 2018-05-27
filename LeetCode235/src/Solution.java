class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode large = p.val > q.val ? p : q;
        TreeNode small = p == large ? q : p;
        if (root == null) return null;
        if ((large.val > root.val && small.val <= root.val)
                || (large.val >= root.val && small.val < root.val)) return root;
        if (small.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);
    }
}
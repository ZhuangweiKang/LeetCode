/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode middle = head;
        for (int i = 0; i < length/2; i++) {
            slow = middle;
            middle = middle.next;
            fast = middle.next;
        }
        slow.next = null;
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);
        return root;
    }
}
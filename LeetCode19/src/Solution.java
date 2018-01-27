/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while(fastNode.next != null){
            if(n <= 0)
                slowNode = slowNode.next;
            fastNode = fastNode.next;
            n--;
        }
        if(slowNode.next != null)
            slowNode.next = slowNode.next.next;
        return headNode.next;
    }
}
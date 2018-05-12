import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode revLinkedList = stack.pop();
        return helper(revLinkedList, stack);
    }

    private ListNode helper(ListNode head, Stack<ListNode> stack) {
        if (stack.isEmpty()) {
            head.next = null;
            return head;
        }
        head.next = helper(stack.pop(), stack);
        return head;
    }
}
import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) stack.push(node);
        int length = stack.size();
        for (ListNode node = head; stack.size() > length/2; node = node.next)
            if (stack.pop().val != node.val) return false;
        return true;
    }
}
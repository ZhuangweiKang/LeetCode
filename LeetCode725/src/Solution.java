import java.util.ArrayList;
import java.util.List;

/*
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        if (root == null){
            return new ListNode[k];
        }
        ListNode temp = root;
        //get the length of this linked list
        while (temp != null){
            length++;
            temp = temp.next;
        }
        int division = length / k;
        int remainder = length % k;
        ListNode[] result = new ListNode[k];
        ListNode node = root;
        ListNode prev_node = null;
        //前remainder组，每组division+1个node
        for (int j = 0; j < remainder; j++) {
            result[j] = node;
            for (int i = 0; i <= division; i++) {
                prev_node = node;
                node = node.next;
            }
            prev_node.next = null;
        }
        //后k-remainder 组，每组division个node
        for (int j = remainder; j < k; j++) {
            result[j] = node;
            for (int i = 0; i < division; i++) {
                prev_node = node;
                node = node.next;
            }
            prev_node.next = null;
        }
        return result;
    }
}

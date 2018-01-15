'''
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def transfer_node(self, mylist, node):
        mylist.append(node.val)
        if node.next is None:
            return mylist
        return self.transfer_node(mylist, node.next)

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l1 = self.transfer_node([], l1)
        l2 = self.transfer_node([], l2)
        l1.reverse()
        l2.reverse()
        subtract = len(l1) - len(l2)
        temp = []
        for i in range(0, abs(subtract)):
            temp.append(0)
        if subtract < 0:
            temp.extend(l1)
            l1 = temp
        elif subtract > 0:
            temp.extend(l2)
            l2 = temp

        result = []
        index = len(l1) - 1
        while index >= 0:
            result.append(l1[index] + l2[index])
            index -= 1

        result.extend([0])
        for i in range(len(result)):
            if result[i] > 9:
                result[i] = result[i] - 10
                result[i+1] += 1
        if result[len(result) - 1] == 0:
            result.pop(len(result) - 1)
        return result
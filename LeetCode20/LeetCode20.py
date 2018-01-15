'''
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
'''
class Solution:
    '''
        def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        last = s
        while len(s) > 0:
            s = s.replace('()', '').replace('[]', '').replace('{}', '')
            if last == s:
                return False
            last = s
        return True
    '''
    '''
    Implementation using Stack
    '''

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for item in s:
            if len(stack) == 0:
                stack.append(item)
            elif (stack[len(stack)-1] == '(' and item == ')') or (stack[len(stack)-1] == '[' and item == ']') or (stack[len(stack)-1] == '{' and item == '}'):
                stack.pop(len(stack)-1)
            else:
                stack.append(item)
        if len(stack) == 0:
            return True
        return False






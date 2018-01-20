'''
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
'''


class Solution:
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        self.backtracking(result, '', 0, 0, n)
        return result

    def backtracking(self, l, st, op, cl, m):
        if len(st) == m * 2:
            l.append(st)
            return
        if op < m:
            self.backtracking(l, st+'(', op+1, cl, m)
        if cl < op:
            self.backtracking(l, st+')', op, cl+1, m)
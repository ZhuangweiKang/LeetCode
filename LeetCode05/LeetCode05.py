'''
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
'''

class Solution(object):
    '''
    #动态规划解法
        def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        result = ''
        for i in range(1, len(s) + 1):
            for index in range(0, len(s)+1-i):
                if s[index: index+i] == (s[index: index+i])[::-1]:
                    result = s[index: index+i]
                    break
        return result
    '''
    #Manacher算法
    def preProcess(self, s):
        result = []
        for item in s:
            result.append(item)
            result.append('#')
        result.pop(len(result) - 1)
        return result

    def longestPalindrome(self, s):
        processed_s = self.preProcess(s)
        p = []
        mx = center_id = 0
        for i, item in enumerate(processed_s):
            if i < mx:

                j = min(mx-i, p[2*center_id-i])
            else:
                j = 0
            while processed_s[i-j:i+j+1] == processed_s[i-j:i+j+1][::-1] and (i-j >= 0):
                j += 1
            p.append(j)
            if i + p[i] > mx:
                center_id = i
                mx = i + j
        temp = max(p)
        temp_index = [index for index, x in enumerate(p) if x == temp]
        result = []
        for item in temp_index:
            result.append(processed_s[item-p[item]+1: item+p[item]])
        for item in result:
            for char in item:
                if char == '#':
                    item.remove('#')
        max_length = 0
        max_index = 0
        for index, item in enumerate(result):
            if len(item) > max_length:
                max_length = len(item)
                max_index = index
        result = result[max_index]
        return ''.join(result)
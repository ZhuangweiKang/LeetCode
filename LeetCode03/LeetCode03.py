'''
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
'''


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = list(s)
        if len(s) == 0:
            return 0
        max_length = len(set(s))
        while max_length > 0:
            for i in range(0, len(s) - max_length + 1):
                if len(set(s[i: i + max_length])) == max_length:
                    return max_length
            max_length -= 1
        return max_length
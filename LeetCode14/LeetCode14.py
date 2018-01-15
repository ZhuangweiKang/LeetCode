'''
Write a function to find the longest common prefix string amongst an array of strings.
'''
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ''
        strs.sort(key=len)
        for index, mychar in enumerate(strs[0]):
            for item in strs:
                if mychar != item[index]:
                    return strs[0][:index]
        return strs[0]
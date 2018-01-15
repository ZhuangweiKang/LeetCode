'''
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
'''
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanNum = {'I': 1, 'X': 10, 'C': 100, 'M': 1000, 'V': 5, 'L': 50, 'D': 500}
        s = list(s)
        result = 0
        for index in range(0, len(s)-1):
            if romanNum[s[index]] >= romanNum[s[index + 1]]:
                result += romanNum[s[index]]
            else:
                result -= romanNum[s[index]]
        return result+romanNum[s[len(s)-1]]
sol = Solution()
print(sol.romanToInt("IV"))
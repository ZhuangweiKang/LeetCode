'''
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
'''

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if len(s) <= 1 or numRows <= 1:
            return s
        processed_s = []
        for i in range(0, numRows):
            processed_s.append([])
        for i, item in enumerate(s):
            if i % (2*numRows - 2) <= numRows-1:
                processed_s[i % (2*numRows-2)].append(item)
            else:
                processed_s[(2*numRows-2) - (i % (2*numRows-2))].append(item)
        processed_s = [''.join(x) for x in processed_s]
        processed_s = ''.join(processed_s)
        return processed_s

solution = Solution()
solution.convert('PAYPALISHIRTNG', 3)
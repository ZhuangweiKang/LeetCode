'''
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
'''
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        romanNum = {1: 'I', 5: 'V', 10: 'X', 50: 'L', 100: 'C', 500: 'D', 1000: 'M'}
        num = list(str(num))
        num = [int(x) * (10 ** (len(num)-index-1)) for index, x in enumerate(num)]
        print(num)
        result = ''
        for index, item in enumerate(num):
            # 1~3, 4, 5, 5~8, 9, 10~30, 40, 50, 50~80, 90
            if item < 4 * (10 ** (len(num)-index-1)):
                for x in range(0, int(item/(10 ** (len(num)-index-1)))):
                    result += romanNum[10 ** (len(num)-index-1)]
            elif item == 4 * (10 ** (len(num)-index-1)):
                result += romanNum[(10 ** (len(num)-index-1))] + romanNum[5 * (10 ** (len(num)-index-1))]
            elif item == 5 * (10 ** (len(num)-index-1)):
                result += romanNum[5 * (10 ** (len(num)-index-1))]
            elif 5 * (10 ** (len(num)-index-1)) < item < 9 * (10 ** (len(num)-index-1)):
                result += romanNum[5 * (10 ** (len(num)-index-1))]
                for x in range(0, int(item/(10 ** (len(num)-index-1)))-5):
                    result += romanNum[10 ** (len(num)-index-1)]
            elif item == 9 * (10 ** (len(num)-index-1)):
                result += romanNum[(10 ** (len(num) - index - 1))] + romanNum[10 ** (len(num)-index)]
        return result
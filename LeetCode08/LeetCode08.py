'''
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
'''

class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = list(str)
        temp_str = []
        for index, item in enumerate(str):
            if item == ' ':
                pass
            else:
                temp_str = str[index:]
                break

        print(temp_str)
        for index, item in enumerate(temp_str):
            if item < '0' or item > '9':
                if index == 0 and (item == '-' or item == '+'):
                    continue
                else:
                    temp_str = temp_str[0: index]
                    break
        print(temp_str)
        if len(temp_str) == 0:
            return 0
        if temp_str[0] == '-' and len(temp_str) == 1:
            return 0
        if temp_str[0] == '+':
            temp_str.remove('+')
        if len(temp_str) == 0:
            return 0
        temp_str = ''.join(temp_str)
        temp_str = int(temp_str)
        if temp_str > 2147483647:
            return 2147483647
        elif temp_str < -2147483648:
            return -2147483648
        else:
            return temp_str



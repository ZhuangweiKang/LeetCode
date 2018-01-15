'''
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
'''
class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        groups = {'1': '', '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
                  '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz', '0': ' '}
        result = []
        for d in digits:
            if len(result) == 0:
                result = groups[d]
            else:
                new_result = []
                for letter in groups[d]:
                    temp = result
                    mytemp = []
                    for item in temp:
                        item += letter
                        mytemp.append(item)
                    new_result.append(mytemp)
                result = []
                for i in new_result:
                    result.extend(i)
        return list(result)





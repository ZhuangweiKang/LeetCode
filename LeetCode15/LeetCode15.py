'''
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
'''


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        for i, num_1 in enumerate(nums):
            for num_2 in nums[i+1:]:
                two_sum = num_1 + num_2
                temp = nums[:]
                temp.remove(num_1)
                temp.remove(num_2)
                temp.sort()
                third = self.twoSum(two_sum, temp)
                if third[0]:
                    new = [num_1, num_2, third[1]]
                    if self.removeRept(new, result):
                        result.append(new)
        return result

    def twoSum(self, target, nums):
        try:
            if target + nums[int((len(nums)-1) / 2)] == 0:
                return True, nums[int((len(nums)-1) / 2)]
            elif target + nums[int((len(nums)-1) / 2)] < 0:
                return self.twoSum(target, nums[1 + int((len(nums)-1) / 2):])
            else:
                return self.twoSum(target, nums[:int((len(nums)-1) / 2)])
        except IndexError:
            return False, None

    def removeRept(self, target, result):
        for item in result:
            item.sort()
            target.sort()
            if target == item:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    print(s.threeSum([-1, 0, 1, 2, -1, -4]))
'''
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
'''


class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        for index, num in enumerate(nums[:len(nums) - 1]):
            if index > 0 and num == nums[index - 1]:
                continue
            for x in self.threeSum(nums[index+1:], target-num):
                x.append(num)
                result.append(x)
        return result

    def threeSum(self, nums, target):
        nums.sort()
        result = []
        for index, num in enumerate(nums[:len(nums) - 1]):
            if index > 0 and num == nums[index - 1]:
                continue
            i = index + 1
            j = len(nums) - 1
            while i < j:
                if nums[i] + nums[j] < target-num:
                    i += 1
                elif nums[i] + nums[j] > target-num:
                    j -= 1
                else:
                    result.append([num, nums[i], nums[j]])
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i - 1]:
                        i += 1
                    while i < j and nums[j] == nums[j + 1]:
                        j -= 1
        return result

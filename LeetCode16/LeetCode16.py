'''
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
'''


class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        result = sum(nums[:3])
        offset = abs(result - target)
        for index, num in enumerate(nums[:len(nums)-1]):
            i = index + 1
            j = len(nums) - 1
            while i < j:
                update = abs(nums[i] + nums[j] + num - target)
                if offset > update:
                    offset = update
                    result = nums[i] + nums[j] + num
                if nums[i] + nums[j] + num > target:
                    j -= 1
                elif nums[i] + nums[j] + num < target:
                    i += 1
                else:
                    return result
        return result
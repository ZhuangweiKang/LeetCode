'''
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
最优化剪枝问题
'''
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 1:
            return 0
        i = 0
        j = len(height) - 1
        # result中存储以每一点为基准得到的最优解
        result = []
        while i != j:
            result.append(min(height[j], height[i]) * (j - i))
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
        return max(result)
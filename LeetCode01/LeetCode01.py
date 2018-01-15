class Solution:
    def twoSum(self, nums, target):
        new_nums = []
        new_nums.extend(nums)
        new_nums.sort()
        flag = 0
        for index, item in enumerate(new_nums):
            if ((item < target / 2 < new_nums[index + 1]) or target/2 == item) and \
                            index != len(new_nums) - 1:
                flag = index
                break

        result_nums = ()
        for small_item in new_nums[0:flag + 1]:
            big_num = self.search(new_nums[flag + 1: len(new_nums)], target-small_item)
            if big_num is not None:
                result_nums = (small_item, big_num)
                break

        # Search
        result_indexes = []
        for index, item in enumerate(nums):
            if item == result_nums[0] or item == result_nums[1]:
                result_indexes.append(index)

        return result_indexes

    # Binary Search
    def search(self, nums, target):
        if len(nums) == 0:
            return None
        if target == nums[int(len(nums)/2)]:
            return target
        elif target < nums[int(len(nums)/2)]:
            return self.search(nums[0:int(len(nums)/2)], target)
        else:
            return self.search(nums[int(len(nums)/2) + 1: len(nums)], target)
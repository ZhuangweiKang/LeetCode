import java.util.*;

/**
 * Created by zkty9 on 3/4/18.
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        findSubsequenceHelper(res, new ArrayList<>(), 0, nums);
        return new ArrayList<>(res);
    }
    private void findSubsequenceHelper(Set<List<Integer>> res, List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2)
            res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                findSubsequenceHelper(res, list, i+1, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
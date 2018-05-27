import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> my_nums = new ArrayList<>();
        for (int num: nums) my_nums.add(num);
        subsetsHelper(my_nums, new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }

    private void subsetsHelper(List<Integer> nums, List<Integer> item) {
        if (nums.size() != 0){
            for (int i = 0; i < nums.size(); i++) {
                item.add(nums.get(i));
                subsetsHelper(nums.subList(i+1, nums.size()), item);
                List<Integer> temp = new ArrayList<>();
                temp.addAll(item);
                result.add(temp);
                item.remove(nums.get(i));
            }
        }
    }
}
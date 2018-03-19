import java.util.ArrayList;
import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
//F[i][j] = Min(F[i-1][j-1], F[i-1][j+1]) + N[i][j]
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        List<List<Integer>> vals = new ArrayList<>();
        vals.add(new ArrayList<>());
        vals.get(0).add(triangle.get(0).get(0));
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            vals.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0)
                    vals.get(i).add(vals.get(i-1).get(j)+triangle.get(i).get(j));
                else if (j == triangle.get(i).size()-1)
                    vals.get(i).add(vals.get(i-1).get(j-1)+triangle.get(i).get(j));
                else
                    vals.get(i).add(Math.min(vals.get(i-1).get(j-1), vals.get(i-1).get(j))+triangle.get(i).get(j));
                if (i == triangle.size()-1)
                    res = Math.min(res, vals.get(i).get(j));
            }
        }
        return res;
    }
}*/
//Better Solution: 从下向上递推
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] vals = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++)
                vals[j] = Math.min(vals[j], vals[j+1]) + triangle.get(i).get(j);
        return vals[0];
    }
}

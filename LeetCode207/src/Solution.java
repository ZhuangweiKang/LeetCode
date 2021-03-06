import java.util.ArrayList;
import java.util.List;
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //用来监控节点是否被访问过
        boolean[] visited = new boolean[numCourses];
        //用来存储每个节点的后继节点
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) lists.add(new ArrayList<>());
        for (int[] pre:prerequisites) lists.get(pre[1]).add(pre[0]);
        for (int i = 0; i < lists.size(); i++)
            if (!canFinishHelper(lists, visited, i, true)) return false;
        return true;
    }
    private boolean canFinishHelper(List<List<Integer>> lists, boolean[] visited, int key, boolean flag) {
        if (flag) {
            for (Integer val:lists.get(key)) {
                if (visited[val]) return false;
                visited[val] = true;
                flag &= canFinishHelper(lists, visited, val, flag);
                visited[val] = false;
            }
        }
        return flag;
    }
}
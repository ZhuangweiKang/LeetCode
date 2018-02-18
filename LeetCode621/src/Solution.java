import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        Map<String, Integer> myMap = new HashMap<>();
        //initialize map
        for (char task:tasks) {
            if (myMap.keySet().contains(String.valueOf(task)))
                myMap.put(String.valueOf(task), myMap.get(String.valueOf(task))+1);
            else myMap.put(String.valueOf(task), 1);
        }
        List<Map.Entry> myList = myMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());
        //m > n
        for (int i = 0; i < myList.size(); i++) {
            count += (int)myList.get(i).getValue() * myList.size()-i;
            for (Map.Entry entry:myList) {
                entry.setValue((Integer)entry.getValue() - (Integer)myList.get(i).getValue());
            }
        }



    }

}

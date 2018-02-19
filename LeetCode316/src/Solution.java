import java.util.*;

/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (char ch:s.toCharArray()) {
            if (map.containsKey(String.valueOf(ch))){
                map.put(String.valueOf(ch), map.get(String.valueOf(ch))+1);
            }else {
                map.put(String.valueOf(ch), 1);
            }
        }
        for (char item:s.toCharArray()) {
            String item_str = String.valueOf(item);
            if (stack.isEmpty()){
                stack.push(item_str);
                map.replace(item_str, map.get(item_str)-1);
                continue;
            }
            if (!stack.contains(item_str)){
                while (!stack.isEmpty() && item_str.charAt(0) < stack.peek().charAt(0) && map.get(stack.peek()) != 0){
                    stack.pop();
                }
                stack.push(item_str);
            }
            map.replace(item_str, map.get(item_str)-1);
        }
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.elementAt(i));
        }
        return builder.toString();
    }
}

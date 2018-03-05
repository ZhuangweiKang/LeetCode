/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 */
class Solution {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < s.length();) {
            if (Character.isLetter(s.charAt(i))) {
                //如果是字母，直接加入
                builder.append(s.charAt(i));
                //向后移动指针
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                //获取重复次数，并移动指针
                StringBuilder rep = new StringBuilder("");
                while (Character.isDigit(s.charAt(i))) {
                    rep.append(s.charAt(i));
                    i++;
                }
                //循环重复字符串重复次数
                for (int k = 0; k < Integer.valueOf(rep.toString()); k++) {
                    //从前向后遍历字符串
                    for (int j = i+1; j < get_end(s, i);) {
                        //如果是字母，直接加入
                        if (Character.isLetter(s.charAt(j))) {
                            builder.append(s.charAt(j));
                            j++;
                        }
                        //如果是数字，递归
                        else if (Character.isDigit(s.charAt(j))) {
                            builder.append(decodeString(s.substring(j, get_end(s, j))));
                            j = get_end(s, j);
                        }
                        else if (s.charAt(j) == '[' || s.charAt(j) == ']') j++;
                    }
                }
                i = get_end(s, i);
            } else if (s.charAt(i) == '[' || s.charAt(i) == ']') i++;
        }
        return builder.toString();
    }

    private int get_end(String s, int i) {
        int stack = 0;
        while (Character.isDigit(s.charAt(i))) i++;
        int end = i;
        while (stack != 0 || end == i) {
            if (s.charAt(end) == '[') stack++;
            if (s.charAt(end) == ']') stack--;
            end++;
        }
        return end;
    }
}
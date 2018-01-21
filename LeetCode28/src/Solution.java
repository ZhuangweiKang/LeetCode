/*
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int i = 0, j = 0, flag = -1;
        while(j < needle.length() && i < haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (flag == -1) flag = i;
                i++; j++;
            }else {
                if (flag == -1) i++;
                else i = flag + 1;
                j = 0; flag = -1;
            }
        }
        if (j == needle.length()) return flag;
        return -1;
    }
}

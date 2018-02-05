/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

 */
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public String reorganizeString(String S) {
        Map<String, Integer> map = new HashMap<>();
        List<String> keys= Arrays.asList(S.split(""));
        for (String key:keys) {
            if (!map.keySet().contains(key)) map.put(key, 1);
            else map.put(key, map.get(key) + 1);
        }
        List<Map.Entry<String, Integer>> map_entry = new ArrayList<>(map.entrySet());
        List<String> temp_result = new ArrayList<>();
        temp_result.add("");
        if (map_entry.size() == 0 || (map_entry.size() == 1 && map_entry.get(0).getValue() > 1)) return "";
        if (map_entry.size() == 1 && map_entry.get(0).getValue() == 1) return S;
        int j = 0;
        while (j < S.length()){
            map_entry = map_entry.stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
            if (!map_entry.get(map_entry.size()-1).getKey().equals(temp_result.get(temp_result.size()-1))){
                temp_result.add(map_entry.get(map_entry.size()-1).getKey());
                map_entry.get(map_entry.size()-1).setValue(map_entry.get(map_entry.size()-1).getValue()-1);
            }else {
                if (map_entry.get(map_entry.size()-2).getValue() == 0) return "";
                temp_result.add(map_entry.get(map_entry.size()-2).getKey());
                map_entry.get(map_entry.size()-2).setValue(map_entry.get(map_entry.size()-2).getValue()-1);
            }
            j++;
        }
        StringBuilder result = new StringBuilder();
        for (String item:temp_result) {
            result.append(item);
        }
        return result.toString();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i+1);
                switch (nextChar) {
                    case '\"': sb.append('\"'); break;
                    case '/' : sb.append('/'); break;
                    case '\\': sb.append('\\'); break;
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'r' : sb.append('\r'); break;
                    case 'n' : sb.append('\n'); break;
                    case 't' : sb.append('\t'); break;
                    default: break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);

            String ret = new Solution().reorganizeString(S);

            String out = (ret);

            System.out.print(out);
        }
    }
}
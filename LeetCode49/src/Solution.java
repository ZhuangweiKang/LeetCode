import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> temp_result = new HashMap<>();
        for (String item:strs) {
            List<Character> chrs = item.chars()
                    .mapToObj(chr -> (char)chr)
                    .collect(Collectors.toList());
            Collections.sort(chrs);
            if (!temp_result.keySet().contains(chrs)) {
                temp_result.put(chrs, new ArrayList<>());
                temp_result.get(chrs).add(item);
            }else {
                temp_result.get(chrs).add(item);
            }
        }
        return new ArrayList<>(temp_result.values());
    }
}
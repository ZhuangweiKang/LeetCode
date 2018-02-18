import java.util.*;
import java.util.stream.Collectors;

/*
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // remove other characters except letters
        List<String> new_licensePlate = new ArrayList<>();
        for (char item : licensePlate.toCharArray()){
            if (item >= 'A' & item <= 'z')
                new_licensePlate.add(String.valueOf(item).toLowerCase());
        }
        // hashmap
        Map<String, Integer> map = new HashMap<>();
        for (String word:words) {
            Integer value = 0;
            String temp = word;
            for (String item:new_licensePlate){
                if (temp.contains(item)){
                    value++;
                    StringBuilder builder = new StringBuilder(temp);
                    builder.deleteCharAt(temp.indexOf(item));
                    temp = builder.toString();
                }
            }
            map.put(word, value);
        }
        Integer maxL = Collections.max(map.values());
        List<String> max_words = new ArrayList<>();
        for (Map.Entry entry:map.entrySet()) {
            if (entry.getValue() == maxL)
                max_words.add((String)entry.getKey());
        }
        List<String> sorted_max_words = max_words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        List<String> new_words = Arrays.stream(words).
                sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        for (String word:new_words) {
            if (sorted_max_words.contains(word))
                return word;
        }
        return "";
    }
}
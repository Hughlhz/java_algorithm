package CSDN10;

import java.util.*;

public class Leetcode451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Map.Entry<Character, Integer>> list = map.entrySet().stream().toList();
        Collections.sort(list,(s1,s2)->(s2.getValue().compareTo(s1.getValue())));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> e:list
             ) {
            sb.append(e.getKey().toString().repeat(e.getValue()));

        }
        return sb.toString();

    }
}

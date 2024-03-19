package hot100.hashmap;

import annotations.Star;

import java.util.*;
@Star
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chr = s.toCharArray();
            Arrays.sort(chr);
            String key = new String(chr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

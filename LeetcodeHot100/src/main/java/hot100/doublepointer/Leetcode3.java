package hot100.doublepointer;

import annotations.Star;

import java.util.HashSet;

@Star("滑动窗口经典，一个尾指针先行，条件符合 处理 记录后再动，不符合的话头指针移动，直到符合")
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow=0,fast=0;
        int max=0;
        while (fast<s.length()){
            if(!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast++));
                max = Math.max(max, set.size());
            }else {
                set.remove(s.charAt(slow++));
            }
        }
        return max;
    }
    public int lengthOfLongestSubstringComplex(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow=0;
        int max=0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch=s.charAt(fast);
            if(!set.contains(ch)){
                set.add(ch);
                max = Math.max(max, set.size());
            }else {
                while (set.contains(s.charAt(fast))) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.add(s.charAt(fast));
            }
        }
        return max;
    }

//    public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet<>();
//        int i=0;
//        int max=0;
//        for (int j = 0; j < s.length(); j++) {
//            char ch=s.charAt(j);
//            if(!set.contains(ch)){
//                set.add(ch);
//                max = Math.max(max, set.size());
//            }else {
//                while (set.contains(s.charAt(j))) {
//                    set.remove(s.charAt(i));
//                    i++;
//                }
//                set.add(s.charAt(j));
//            }
//        }
//        return max;
//    }
}

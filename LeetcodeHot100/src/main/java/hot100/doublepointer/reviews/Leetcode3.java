package hot100.doublepointer.reviews;

public class Leetcode3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] map = new int[128];
            int fast=0,slow=0;
            int max=0;
            while (fast < s.length()) {
                if(map[s.charAt(fast)]==0) {
                    map[s.charAt(fast++)]++;
                    max = Math.max(fast - slow, max);
                }else {
                    while (map[s.charAt(fast)]!=0){
                        map[s.charAt(slow++)]--;
                    }
                }
            }
            return max;
        }
    }
}

package hot100.doublepointer;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char ch : t.toCharArray()) {
            cnt[ch]++;
        }
        int fast=0,slow=0;
        int cntConut=t.length();//有效字符数
        int resStart=0,len=Integer.MAX_VALUE;
        while (fast < s.length()) {
            if (cntConut != 0) {//不包含，也就是有效字符数不为0 继续后移
                if(cnt[s.charAt(fast++)]-->0) cntConut--;//后移，如果是有效字符 cntCount--；
            }
            //包含 也就是有效字符数为0，前指针移
            while (cntConut==0){
            //记录最小
                if (len > fast - slow) {
                    len=fast-slow;
                    resStart=slow;
                }
                //移除
                if (cnt[s.charAt(slow++)]++ == 0) cntConut++;//如果移除的是有效字符，cntCount++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + len);
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        System.out.println(leetcode76.minWindow("asbaaacbbddaabbdd", "aabb"));
    }
}

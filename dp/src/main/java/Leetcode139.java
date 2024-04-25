import annotations.Star;

import java.util.Arrays;
import java.util.List;
@Star("1、理解背包的容量是在单位字符维度的，通常的背包理解是单位重量维度;2、理解并不是满足字符个数就能装入背包，而是要符合字符要求（第二个循环每次都要从头开始）")
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0]=true;
//        for (int j = 1; j < s.length() + 1; j++) {
//            for (int i = 0; i < j; i++) {
//                String word = s.substring(i, j);
//                if (wordDict.contains(word) && dp[i]) {
//                    dp[j]=true;
//                }
//            }
//        }
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (wordDict.contains(word) && dp[j]) {
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];

    }
}

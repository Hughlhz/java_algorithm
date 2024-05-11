package hot100.dynamic;

import annotations.Star;

import java.util.List;
@Star("单词拆分问题，想象成用字符串去装字典里的词语，由于字符串是单词的排列而非组合，所以要先遍历背包，后遍历物品")
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0]=true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if(wordDict.contains(word)&&dp[j]){
                    dp[i]=true;
                }
            }

        }
        return dp[s.length()];
    }
}

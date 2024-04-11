package hot100.dynamic;

import annotations.Star;

@Star("1、理解先遍历物品，物品是内部有序的，所以算出来的是集合数 2、理解内层顺序遍历解决的是完全背包问题 3、理解递推公式，包含两种情况：加入物品i 和 不加入物品i")
public class Leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}

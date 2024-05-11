package hot100.dynamic;
import java.math.*;
public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        //组合数学方法
        //回顾：A(n,m)=n!/(n-m)!   也就是 n*(n-1)*...*(n-m+1)
        //     C(n,m)=n!/((n-m)!*m!)  也就是 从n个数任选m个数排列后 除以m个数全排列的方法数
        //这道题 往下m-1次，往左n-1次，一定可以到达终点，所以利用C(m+n-2,n-1) 就可以计算得到
        return  fac(m + n - 2).divide(fac(m - 1).multiply(fac(n - 1))).intValue();
    }

    private BigInteger fac(int i) {
        if( i==1||i==0) return new BigInteger("1");
        return fac(i - 1).multiply(BigInteger.valueOf(i));
    }

    //动态规划方法
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            dp[1][i]=1;
//        }
//        for (int i = 1; i < m + 1; i++) {
//            dp[i][1]=1;
//        }
        dp[0][1]=1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }


}

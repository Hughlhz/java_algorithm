package hot100.tree;

import annotations.Star;

@Star("树形dp或者直接递归全局变量记录值")
public class Leetcode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[2];

    }

    public int[] dfs(TreeNode root){
        int dp[]=new int[3];
        if(root.left==null&&root.right==null){
            return dp;
        }
        int left[];
        int right[];
        if(root.left!=null) {
            left = dfs(root.left);
            dp[0]=Math.max(left[0],left[1])+1;
            dp[2] = Math.max(left[2], dp[2]);
        }
        if(root.right!=null) {
            right = dfs(root.right);
            dp[1]=Math.max(right[0],right[1])+1;
            dp[2] = Math.max(right[2], dp[2]);
        }
        dp[2] = Math.max(dp[2], dp[0] + dp[1]);
        return dp;
    }
}

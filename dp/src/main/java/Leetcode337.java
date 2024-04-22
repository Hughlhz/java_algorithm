import annotations.Star;

import java.util.Arrays;
import java.util.Map;
@Star("树形DP 从叶子节点对应的子问题往上推导，采用的往往是后序遍历")
public class Leetcode337 {
//    public int rob(TreeNode root) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        HashMap<TreeNode, Integer> dpMap = new HashMap<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.peek();
//            if (node != null) {
//                stack.push(null);
//                if (node.left != null) {
//                    stack.push(node.left);
//                }
//                if (node.right != null) {
//                    stack.push(node.right);
//                }
//            } else {
//                stack.pop();
//                TreeNode temp = stack.pop();
//                //两种情况，选自己，那么加上左右子树的所有子孙；不选自己，那么就是左右子树之和
//                if (temp.right == null && temp.left == null) {
//                    dpMap.put(temp, temp.val);
//                } else {
//                    //不选自己
//                    int sum1 = (temp.left == null ? 0 : dpMap.get(temp.left)) + (temp.right == null ? 0 : dpMap.get(temp.right));
//                    int sum2 = temp.val;
//                    if (temp.left != null) {
//                        sum2 += (temp.left.left == null ? 0 : dpMap.get(temp.left.left)) + (temp.left.right == null ? 0 : dpMap.get(temp.left.right));
//                    }
//                    if (temp.right != null) {
//                        sum2 += (temp.right.left == null ? 0 : dpMap.get(temp.right.left)) + (temp.right.right == null ? 0 : dpMap.get(temp.right.right));
//
//                    }
//                    dpMap.put(temp, Math.max(sum1, sum2));
//
//                }
//
//            }
//        }
//        return dpMap.get(root);
//
//    }

    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //偷自己
        int sum=root.val;
        sum += root.left == null ? 0 : rob1(root.left.left) + rob1(root.left.right);
        sum += root.right == null ? 0 : rob1(root.right.left) + rob1(root.right.right);

        return Math.max(sum, rob1(root.left) + rob1(root.right));
    }
    int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int money = root.val;
        if (root.left != null) {
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if (root.right != null) {
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }

    public int rob(TreeNode root) {
        int [] res=robTree(root);
        return Arrays.stream(res).max().orElse(0);
    }

    private int[] robTree(TreeNode root) {

        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int left[] = robTree(root.left);
        int right[] = robTree(root.right);
        res[0] = Math.max(left[1], left[0]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }


}

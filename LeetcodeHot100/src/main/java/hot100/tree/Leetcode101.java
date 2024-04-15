package hot100.tree;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (right == null && left != null) {
            return false;
        }
        if (right == left) {
            return true;
        }
        if (left.val == right.val) {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
        return false;
    }
}

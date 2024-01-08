import com.sun.source.tree.Tree;

import java.util.Stack;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    boolean compare(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1!=null&&t2==null){
            return false;
        }
        if (t1 == null && t2 != null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return compare(t1.left, t2.right) & compare(t1.right, t2.left);
    }

    public boolean isSymmetric_(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        TreeNode t1,t2;
        while (!stack.isEmpty()) {
            t1 = stack.pop();
            t2 = stack.pop();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null && t2 != null) {
                return false;
            }
            if (t1 != null && t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }

            if (t1.val == t2.val) {
                stack.push(t1.left);
                stack.push(t2.right);
                stack.push(t1.right);
                stack.push(t2.left);
            }



        }
        return true;
    }
}




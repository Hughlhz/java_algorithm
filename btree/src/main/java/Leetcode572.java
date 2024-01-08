import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode572 {


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public boolean isSubtree_(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int size=1;
        queue.add(root);
        TreeNode temp;
        boolean flag=false;
        while (!queue.isEmpty()) {
         int temp_size=0;
            for (int i = 0; i < size; i++) {
                temp=queue.poll();
                if (temp.val == subRoot.val) {
                    if(isSame(temp, subRoot)) flag=true;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                    temp_size++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    temp_size++;
                }
            }
            size=temp_size;
        }
return  flag;
    }

    public boolean isSame(TreeNode treeNode1,TreeNode treeNode2) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode1);
        stack.push(treeNode2);
        TreeNode t1,t2;
        while (!stack.isEmpty()) {
            t1 = stack.pop();
            t2 = stack.pop();
            if (t1 == null && t2 != null) {
                return false;
            }
            if (t1 != null && t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1.val == t2.val) {
                stack.push(t1.left);
                stack.push(t2.left);
                stack.push(t1.right);
                stack.push(t2.right);
            }
        }
        return true;
    }
}

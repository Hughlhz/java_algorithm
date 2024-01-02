import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Leetcode144 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
    preorder(root);

    return result;
    }
    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal_(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tempNode;
        while (!stack.empty()) {
            tempNode=stack.pop();
            result.add(tempNode.val);
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }


        return result;
    }
}

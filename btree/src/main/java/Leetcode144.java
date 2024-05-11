import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Integer> preorderTraversal__(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p;
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            p = stack.peek();
            if (p != null) {
                stack.pop();

                if (p.right != null) {
                    stack.push(p.right);
                }

                if (p.left != null) {
                    stack.push(p.left);
                }
                stack.push(p);
                stack.push(null);

            }else {
                stack.pop();
                p=stack.pop();
                result.add(p.val);
            }
        }
        return result;
    }
    public List<Integer> preorderTraversal___(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p=root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                result.add(p.val);
                if (p.right != null) {
                    stack.push(p.right);
                }
                p=p.left;
            }
            p = stack.pop();
        }
        return result;
    }

    public List<Integer> preorderTraversal0(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer>result= new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node!=null)
            {
                if(node.right!= null)stack.push(node.right);
                if(node.left!=null)stack.push(node.left);
                stack.push(node);
                stack.push(null);
            }else {
                result.add(stack.pop().val);
            }
        }
        return result;
    }
}

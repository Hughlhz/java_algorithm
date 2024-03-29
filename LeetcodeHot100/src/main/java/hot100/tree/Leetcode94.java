package hot100.tree;

import annotations.Star;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
@Star("二叉树遍历用递归或者通过栈模拟递归；模拟递归的思路是：每次循环 取出一个节点，获取子节点，并按照递归返回的顺序压栈")
public class Leetcode94 {
    //    List results = new ArrayList<Integer>();
//
//
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        inorder(root);
//        return results;
//
//    }
//
//    private void inorder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            inorder(root.left);
//        }
//        results.add(root.val);
//        if (root.right != null) {
//            inorder(root.right);
//        }
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }

            } else {
                stack.pop();
                result.add(stack.peek().val);
                stack.pop();
            }
        }
        return result;
    }
}

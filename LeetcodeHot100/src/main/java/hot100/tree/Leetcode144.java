package hot100.tree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
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

                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);

            } else {
                stack.pop();
                result.add(stack.peek().val);
                stack.pop();
            }
        }
        return result;
    }
}

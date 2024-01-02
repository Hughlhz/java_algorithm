import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);

        return result;
    }

    void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        result.add(root.val);

    }

    public List<Integer> postorderTraversal_(TreeNode root) {
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

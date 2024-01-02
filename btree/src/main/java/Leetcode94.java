import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);

        return result;
    }


    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        result.add(root.val);

        inorder(root.right);

    }


    public List<Integer> inorderTraversal_(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tempNode=root;
        while (tempNode!=null||!stack.empty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            result.add(tempNode.val);
            tempNode = tempNode.right;
        }

        return result;
    }
}

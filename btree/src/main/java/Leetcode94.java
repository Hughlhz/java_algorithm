import java.util.ArrayList;
import java.util.List;

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
}

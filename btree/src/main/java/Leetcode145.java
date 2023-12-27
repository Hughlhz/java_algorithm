import java.util.ArrayList;
import java.util.List;

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
}

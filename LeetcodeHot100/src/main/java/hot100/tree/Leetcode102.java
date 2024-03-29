package hot100.tree;

import annotations.Star;

import java.util.LinkedList;
import java.util.List;
@Star("层序遍历用队列")
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> path = new LinkedList<>();
            count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.removeFirst();
                path.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(path);
        }
        return result;
    }
}

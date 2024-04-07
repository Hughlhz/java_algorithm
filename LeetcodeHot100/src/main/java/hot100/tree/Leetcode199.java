package hot100.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        TreeNode node;
        int count=1;
        int sum=0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < count; i++) {
                node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    sum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum++;
                }
                if (i == count - 1) {
                    result.add(node.val);
                }
            }
            count=sum;
            sum=0;
        }
        return result;
    }
}

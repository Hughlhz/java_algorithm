import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
        {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size=0;
        TreeNode temp;
        while (!queue.isEmpty()) {
            size=queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                temp=queue.poll();
                tempList.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            }
            result.add(tempList);
        }
        return  result;
    }
}

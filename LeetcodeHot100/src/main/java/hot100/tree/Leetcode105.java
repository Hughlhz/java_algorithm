package hot100.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if(preLeft>preRight) return null;
        int rootVal=preorder[preLeft];
        int root_in_index=map.get(rootVal);
        int leftCount=root_in_index-inLeft;
        int rightCount=inRight-root_in_index;
        TreeNode root= new TreeNode(rootVal);
        root.left=build(preorder,preLeft+1,preLeft+leftCount,inorder,inLeft,root_in_index-1);
        root.right=build(preorder,preLeft+leftCount+1,preRight,inorder,root_in_index+1,inRight);
        return root;
    }
}

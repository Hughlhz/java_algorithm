package hot100.tree;

public class Leetcode114 {
    //把右子树 挂到当前左子树的最右边 然后重复
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                root=root.right;
            }else{
                TreeNode pre=root.left;
                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }
}

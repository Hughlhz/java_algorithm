public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if(root==null) return;
        TreeNode temp=root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            invert(root.left);
        }

        if (root.right != null) {
            invert(root.right);
        }

    }


}

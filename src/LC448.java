public class LC448 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cand = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            }
            else {
                cand = root;
                root = root.left;
            }
        }
        return cand;
    }
}

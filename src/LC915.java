public class LC915 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private TreeNode predecessor;

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        dfs(root, p);

        return predecessor;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return ;
        }

        // Left hand side
        if (root.val >= p.val) {
            dfs(root.left, p);
        }
        else {
            // Find the current predecessor
            predecessor = root;
            dfs(root.right, p);
        }
    }
}

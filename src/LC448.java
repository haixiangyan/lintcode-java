public class LC448 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode successor;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        dfs(root, p);

        return successor;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }

        if (root.val <= p.val) {
            dfs(root.right, p);
        }
        else {
            successor = root;
            dfs(root.left, p);
        }
    }
}

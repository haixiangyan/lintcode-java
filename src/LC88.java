public class LC88 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (root == A || root == B) {
            return root;
        }

        if (left != null && right != null) {
            if (left == right) {
                return left;
            }
            else {
                return root;
            }
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}

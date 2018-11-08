public class LC475 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root);
    }

    private int divideConquer(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMaxSum = divideConquer(root.left);
        int rightMaxSum = divideConquer(root.right);

        return root.val + Math.max(0, Math.max(leftMaxSum, rightMaxSum));
    }
}

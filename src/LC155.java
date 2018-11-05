public class LC155 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root);
    }

    private int divideConquer(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftMin = divideConquer(root.left);
        int rightMin = divideConquer(root.right);
        return Math.min(leftMin, rightMin) + 1;
    }
}

public class LC93 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public boolean isBalanced;
        public int depth;
        public ResultType(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}

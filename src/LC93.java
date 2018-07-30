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
        return check(root).isBalanced;
    }

    private ResultType check(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType leftResult = check(root.left);
        ResultType rightResult = check(root.right);

        if (!leftResult.isBalanced || !rightResult.isBalanced) {
            return new ResultType(false, -1);
        }
        if (Math.abs(leftResult.depth - rightResult.depth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(leftResult.depth, rightResult.depth) + 1);
    }
}

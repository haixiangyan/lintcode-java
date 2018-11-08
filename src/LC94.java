public class LC94 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public int maxFromRoot, maxInSubtree;
        public ResultType(int maxFromRoot, int maxInSubtree) {
            this.maxFromRoot = maxFromRoot;
            this.maxInSubtree = maxInSubtree;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root).maxInSubtree;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        ResultType leftRt = divideConquer(root.left);
        ResultType rightRt = divideConquer(root.right);

        // Update maxFromRoot
        int maxFromRoot = Math.max(leftRt.maxFromRoot, rightRt.maxFromRoot) + root.val;
        maxFromRoot = Math.max(maxFromRoot, 0);

        // Update maxInSubtree
        int maxInSubtree = Math.max(leftRt.maxInSubtree, rightRt.maxInSubtree);
        maxInSubtree = Math.max(maxInSubtree, leftRt.maxFromRoot + rightRt.maxFromRoot + root.val);

        return new ResultType(maxFromRoot, maxInSubtree);
    }
}

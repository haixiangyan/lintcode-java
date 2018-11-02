public class LC596 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public TreeNode minSubtree;
        public int minSum, sum;
        public ResultType(TreeNode minSubtree, int minSum, int sum) {
            this.minSubtree = minSubtree;
            this.sum = sum;
            this.minSum = minSum;
        }
    }

    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return root;
        }

        return divideConquer(root).minSubtree;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        ResultType result = new ResultType(
                root,
                left.sum + right.sum + root.val,
                left.sum + right.sum + root.val
        );

        if (left.minSum <= result.minSum) {
            result.minSum = left.minSum;
            result.minSubtree = left.minSubtree;
        }
        if (right.minSum <= result.minSum) {
            result.minSum = right.minSum;
            result.minSubtree = right.minSubtree;
        }

        return result;
    }
}

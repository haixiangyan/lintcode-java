public class LC597 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode subtree;
    private ResultType subtreeResult;

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        divideConquer(root);

        return subtree;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType leftResult = divideConquer(root.left);
        ResultType rightResult = divideConquer(root.right);
        ResultType result = new ResultType(
                leftResult.sum + rightResult.sum + root.val,
                leftResult.size + rightResult.size + 1
        );

        if (subtree == null || result.sum * subtreeResult.size > subtreeResult.sum * result.size) {
            subtree = root;
            subtreeResult = result;
        }

        return result;
    }
}

public class LC95 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public boolean isBST;
        public TreeNode minNode, maxNode;
        public ResultType(boolean isBST) {
            this.isBST = isBST;
            this.minNode = null;
            this.maxNode = null;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= root.val) {
            return new ResultType(false);
        }
        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }

        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;

        return result;
    }
}

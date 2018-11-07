public class LC595 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public int maxInSubtree;
        public int maxFromRoot;
        public ResultType(int maxInSubtree, int maxFromRoot) {
            this.maxInSubtree = maxInSubtree;
            this.maxFromRoot = maxFromRoot;
        }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root).maxInSubtree;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        // 加上 root，当前就是1
        ResultType result = new ResultType(0, 1);

        if (root.left != null && root.val + 1 == root.left.val) {
            result.maxFromRoot = Math.max(
                    result.maxFromRoot,
                    left.maxFromRoot + 1
            );
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            result.maxFromRoot = Math.max(
                    result.maxFromRoot,
                    right.maxFromRoot + 1
            );
        }

        result.maxInSubtree = Math.max(
                result.maxFromRoot,
                Math.max(left.maxInSubtree, right.maxInSubtree)
        );

        return result;
    }
}
